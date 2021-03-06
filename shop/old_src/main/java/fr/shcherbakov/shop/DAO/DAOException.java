package fr.shcherbakov.shop.DAO;

public class DAOException extends RuntimeException {
    /*
     * Constructors
     */
    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}