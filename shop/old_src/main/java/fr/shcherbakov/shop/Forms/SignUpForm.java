package fr.shcherbakov.shop.Forms;

import fr.shcherbakov.shop.Model.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SignUpForm {
    public static final String CHAMP_EMAIL  = "email";
    public static final String CHAMP_PASS   = "password";
    public static final String CHAMP_CONF   = "confirmation";
    public static final String CHAMP_NOM    = "name";

    String result;
    Map<String, String> errors = new HashMap<>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public Client signUpClient( HttpServletRequest request ) {
        String email = getFieldValue( request, CHAMP_EMAIL );
        String password = getFieldValue( request, CHAMP_PASS );
        String confirmation = getFieldValue( request, CHAMP_CONF );
        String nom = getFieldValue( request, CHAMP_NOM );

        Client client = new Client();

        try {
            validateEmail( email );
        } catch ( Exception e ) {
            setError( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( email );

        try {
            validatePassword( password, confirmation );
        } catch ( Exception e ) {
            setError( CHAMP_PASS, e.getMessage() );
            setError( CHAMP_CONF, null );
        }
        client.setPassword( password );

        try {
            validateName( nom );
        } catch ( Exception e ) {
            setError( CHAMP_NOM, e.getMessage() );
        }
        client.setName( nom );

        if ( errors.isEmpty() ) {
            result = "Succès de l'inscription.";
        } else {
            result = "Échec de l'inscription.";
        }

        return client;
    }


    private void validateEmail(String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validatePassword(String password, String confirmation ) throws Exception {
        if ( password != null && confirmation != null ) {
            if ( !password.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( password.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validateName(String name ) throws Exception {
        if ( name != null && name.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void setError(String champ, String message ) {
        errors.put( champ, message );
    }

    private static String getFieldValue(HttpServletRequest request, String field ) {
        String value = request.getParameter( field );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value.trim();
        }
    }
}
