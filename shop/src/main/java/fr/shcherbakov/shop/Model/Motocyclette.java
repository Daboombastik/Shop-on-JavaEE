package fr.shcherbakov.shop.Model;

public class Motocyclette extends Vehicule{

    String immatriculation;

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Motocyclette(String type, String moteur, int puissance,String immatriculation) {
        super("moto", moteur, puissance);
        this.immatriculation = immatriculation;

    }


}
