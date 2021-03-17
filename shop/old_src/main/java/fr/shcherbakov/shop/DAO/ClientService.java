package fr.shcherbakov.shop.DAO;

import fr.shcherbakov.shop.Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService implements ClientDAO {
    private final DAOFactory daoFactory;
    private Connection connexion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private ResultSet generatedValues = null;
    private Client client = null;
    private static final String SQL_SELECT_PAR_EMAIL =
            "SELECT id, email, nom, mot_de_passe, date_inscription FROM clients WHERE email = ?";
    private static final String SQL_INSERT =
            "INSERT INTO clients (email, mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, NOW())";

    ClientService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public void create(Client client) throws IllegalArgumentException, DAOException {
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtil.initPreparedStatement(
                    connexion, SQL_INSERT, true, client.getEmail(), client.getPassword(), client.getName());
            int status = preparedStatement.executeUpdate();
            if (status == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
            generatedValues = preparedStatement.getGeneratedKeys();
            if (generatedValues.next()) {
                client.setId(generatedValues.getLong(1));
            } else {
                throw new DAOException("Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtil.gracefulClose(generatedValues, preparedStatement, connexion);
        }
    }

    @Override
    public Client findByMail(String email) throws DAOException {
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtil.initPreparedStatement(connexion, SQL_SELECT_PAR_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtil.gracefulClose(resultSet, preparedStatement, connexion);
        }

        return client;
    }

    private static Client map(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getLong("id"));
        client.setEmail(resultSet.getString("email"));
        client.setPassword(resultSet.getString("mot_de_passe"));
        client.setName(resultSet.getString("nom"));
        client.setDateInscription(resultSet.getTimestamp("date_inscription"));
        return client;
    }
}
