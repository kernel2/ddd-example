package fr.victorianfashion.api.domain.Delivery;

public class Adresse {
    private int number;
    private String wayType;
    private String wayName;
    private int zipCode;
    private String city;
    private String country;

    public boolean isValidDeliveryZone(){
        if(this.country != "France"){
            return false;
        }
        if(this.zipCode < 1590 || this.zipCode>78000 ){
            return  false;
        }
        return true;
    }
}
