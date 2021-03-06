package fr.shcherbakov.shop.DAO;

public class DAOConfigurationException extends RuntimeException {

    /*
     * Constructors
     */
    public DAOConfigurationException( String message ) {
        super( message );
    }

    public DAOConfigurationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOConfigurationException( Throwable cause ) {
        super( cause );
    }
}
