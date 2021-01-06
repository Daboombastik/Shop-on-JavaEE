package fr.shcherbakov.shop.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Order {
    String date, total, payMode, deliveryMode, payStatus, deliveryStatus;

    public Order() {
    }

    public void mapOrder (HttpServletRequest request) {

        Map<String, String[]> orderMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entrySet: orderMap.entrySet()) {
            switch (entrySet.getKey()) {
                case "dateCommande" : setDate(entrySet.getValue()[0]); break;
                case "montantCommande" : setTotal(entrySet.getValue()[0]);break;
                case "modePaiementCommande" : setPayMode(entrySet.getValue()[0]);break;
                case "statutPaiementCommande" : setPayStatus(entrySet.getValue()[0]);break;
                case "modeLivraisonCommande" : setDeliveryMode(entrySet.getValue()[0]);break;
                case "statutLivraisonCommande" : setDeliveryStatus(entrySet.getValue()[0]);break;
            }
        }
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
