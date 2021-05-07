package fr.victorianfashion.api.domain.Delivery;

public class Delivery {
    private String referenceNumber;
    private Adresse adresse;
    private String state;

    public Delivery(String referenceNumber, Adresse adresse) {
        this.referenceNumber = referenceNumber;
        this.adresse = adresse;
        this.state = "pending";
    }
    public boolean isValidAddress(){
        return this.adresse.isValidDeliveryZone();
    }

    public void ship(){
        this.state = "shipped";
    }

    public void receive(){
        this.state = "received";
    }

}
