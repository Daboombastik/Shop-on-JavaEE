package fr.shcherbakov.shop.Model;

public class Vehicule {

    String type;
    String moteur;
    int puissance;

    public Vehicule(String type, String moteur, int puissance) {
        this.type = type;
        this.moteur = moteur;
        this.puissance = puissance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
