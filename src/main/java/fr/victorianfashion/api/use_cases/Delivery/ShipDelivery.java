package fr.victorianfashion.api.use_cases.Delivery;

import fr.victorianfashion.api.domain.Delivery.Delivery;

public class ShipDelivery {
    private DeliveryRepository deliveries;

    public ShipDelivery(DeliveryRepository deliveries) {
        this.deliveries = deliveries;
    }

    public Delivery shipe(String referenceNumber) throws Exception{
        Delivery delivery = deliveries.findDeliveryByReference(referenceNumber);
        if(!delivery.isValidAddress()){
            throw new Exception("Invalid delivery address");
        }
        delivery.ship();
        deliveries.save(delivery);
        return delivery;
    }
}
