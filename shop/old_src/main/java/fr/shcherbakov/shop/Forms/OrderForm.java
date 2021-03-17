package fr.shcherbakov.shop.Forms;

import fr.shcherbakov.shop.Model.Client;
import fr.shcherbakov.shop.Model.Order;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class OrderForm {

    private static final String CHAMP_DATE = "dateCommande";
    private static final String CHAMP_MONTANT = "montantCommande";
    private static final String CHAMP_MODE_PAIEMENT = "modePaiementCommande";
    private static final String CHAMP_STATUT_PAIEMENT = "statutPaiementCommande";
    private static final String CHAMP_MODE_LIVRAISON = "modeLivraisonCommande";
    private static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";

    private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";

    private String result;
    private Map<String, String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public Order createOrder(HttpServletRequest request) {

        ClientForm clientForm = new ClientForm();
        Client client = clientForm.createClient(request);

        errors = clientForm.getErrors();

        LocalDate dt = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        String date = dt.format(formatter);

        String amount = getFieldValue(request, CHAMP_MONTANT);
        String payMode = getFieldValue(request, CHAMP_MODE_PAIEMENT);
        String payStatus = getFieldValue(request, CHAMP_STATUT_PAIEMENT);
        String deliveryMode = getFieldValue(request, CHAMP_MODE_LIVRAISON);
        String deliveryStatus = getFieldValue(request, CHAMP_STATUT_LIVRAISON);

        Order order = new Order();

        order.setClient(client);

        order.setDate(date);

        double valueAmount = -1;
        try {
            valueAmount = validateAmount(amount);
        } catch (Exception e) {
            setErrors(CHAMP_MONTANT, e.getMessage());
        }
        order.setTotal(valueAmount);

        try {
            validatePayMode(payMode);
        } catch (Exception e) {
            setErrors(CHAMP_MODE_PAIEMENT, e.getMessage());
        }
        order.setPayMode(payMode);

        try {
            validatePayStatus(payStatus);
        } catch (Exception e) {
            setErrors(CHAMP_STATUT_PAIEMENT, e.getMessage());
        }
        order.setPayStatus(payStatus);

        try {
            validateDeliveryMode(deliveryMode);
        } catch (Exception e) {
            setErrors(CHAMP_MODE_LIVRAISON, e.getMessage());
        }
        order.setDeliveryMode(deliveryMode);

        try {
            validateDeliveryStatus(deliveryStatus);
        } catch (Exception e) {
            setErrors(CHAMP_STATUT_LIVRAISON, e.getMessage());
        }
        order.setDeliveryStatus(deliveryStatus);

        if (errors.isEmpty()) {
            result = "Succès de la création de la order.";
        } else {
            result = "Échec de la création de la order.";
        }
        return order;
    }

    private double validateAmount(String amount) throws Exception {
        double temp;
        if (amount != null) {
            try {
                temp = Double.parseDouble(amount);
                if (temp < 0) {
                    throw new Exception("Le amount doit être un nombre positif.");
                }
            } catch (NumberFormatException e) {
                temp = -1;
                throw new Exception("Le amount doit être un nombre.");
            }
        } else {
            temp = -1;
            throw new Exception("Merci d'entrer un amount.");
        }
        return temp;
    }

    private void validatePayMode(String payMode) throws Exception {
        if (payMode != null) {
            if (payMode.length() < 2) {
                throw new Exception("Le mode de paiement doit contenir au moins 2 caractères.");
            }
        } else {
            throw new Exception("Merci d'entrer un mode de paiement.");
        }
    }

    private void validatePayStatus(String payStatus) throws Exception {
        if (payStatus != null && payStatus.length() < 2) {
            throw new Exception("Le statut de paiement doit contenir au moins 2 caractères.");
        }
    }

    private void validateDeliveryMode(String deliveryMode) throws Exception {
        if (deliveryMode != null) {
            if (deliveryMode.length() < 2) {
                throw new Exception("Le mode de livraison doit contenir au moins 2 caractères.");
            }
        } else {
            throw new Exception("Merci d'entrer un mode de livraison.");
        }
    }

    private void validateDeliveryStatus(String deliveryStatus) throws Exception {
        if (deliveryStatus != null && deliveryStatus.length() < 2) {
            throw new Exception("Le statut de livraison doit contenir au moins 2 caractères.");
        }
    }

    private void setErrors(String champ, String message) {
        errors.put(champ, message);
    }

    private static String getFieldValue(HttpServletRequest request, String field) {
        String value = request.getParameter(field);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value;
        }
    }
}
