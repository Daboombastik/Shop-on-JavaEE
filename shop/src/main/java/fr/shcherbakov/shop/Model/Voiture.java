package fr.shcherbakov.shop.Model;

public class Voiture extends Vehicule {

    String immatriculation;

    public Voiture(String type, String moteur, int puissance, String immatriculation) {
        super("voiture", moteur, puissance);
        this.immatriculation = immatriculation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
