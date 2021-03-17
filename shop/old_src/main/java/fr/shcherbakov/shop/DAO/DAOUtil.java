package fr.shcherbakov.shop.DAO;

import java.sql.*;

public class DAOUtil {

    public static PreparedStatement initPreparedStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }

    public static void gracefulClose(ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed to close ResultSet : " + e.getMessage() );
            }
        }
    }

    public static void gracefulClose(Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed to close Statement : " + e.getMessage() );
            }
        }
    }

    public static void gracefulClose(Connection connection ) {
        if ( connection != null ) {
            try {
                connection.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed to close Connection : " + e.getMessage() );
            }
        }
    }

    public static void gracefulClose( Statement statement, Connection connexion ) {
        gracefulClose( statement );
        gracefulClose( connexion );
    }

    public static void gracefulClose( ResultSet resultSet, Statement statement, Connection connexion ) {
        gracefulClose( resultSet );
        gracefulClose( statement );
        gracefulClose( connexion );
    }


}
