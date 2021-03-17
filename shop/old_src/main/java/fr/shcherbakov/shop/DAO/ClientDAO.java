package fr.shcherbakov.shop.DAO;

import fr.shcherbakov.shop.Model.Client;

public interface ClientDAO {

    void create( Client client ) throws DAOException;

    Client findByMail( String email ) throws DAOException;
}
