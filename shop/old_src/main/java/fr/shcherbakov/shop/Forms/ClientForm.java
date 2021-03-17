package fr.shcherbakov.shop.Forms;

import fr.shcherbakov.shop.Model.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ClientForm {

    private static final String CHAMP_NAME = "lName";
    private static final String CHAMP_SURNAME = "fName";
    private static final String CHAMP_ADDRESS = "address";
    private static final String CHAMP_TELEPHONE = "telephone";
    private static final String CHAMP_EMAIL     = "email";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public Client createClient(HttpServletRequest request ) {
        String lName = getValeurChamp( request, CHAMP_NAME);
        String fName = getValeurChamp( request, CHAMP_SURNAME);
        String address = getValeurChamp( request, CHAMP_ADDRESS);
        String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
        String email = getValeurChamp( request, CHAMP_EMAIL );

        Client client = new Client();

        try {
            validationNom( lName );
        } catch ( Exception e ) {
            setErreur(CHAMP_NAME, e.getMessage() );
        }
        client.setSurname( lName );

        try {
            validationPrenom( fName );
        } catch ( Exception e ) {
            setErreur(CHAMP_SURNAME, e.getMessage() );
        }
        client.setName( fName );

        try {
            validationAdresse( address );
        } catch ( Exception e ) {
            setErreur(CHAMP_ADDRESS, e.getMessage() );
        }
        client.setAddress( address );

        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        client.setPhone( telephone );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( email );

        if ( errors.isEmpty() ) {
            result = "Succès de la création du client.";
        } else {
            result = "Échec de la création du client.";
        }

        return client;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new Exception( "L'adresse de livraison doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une adresse de livraison." );
        }
    }

    private void validationTelephone( String telephone ) throws Exception {
        if ( telephone != null ) {
            if ( !telephone.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( telephone.length() < 4 ) {
                throw new Exception( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        errors.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
