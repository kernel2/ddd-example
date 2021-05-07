package fr.victorianfashion.api.use_cases.Delivery;

import fr.victorianfashion.api.domain.Delivery.Delivery;

public interface DeliveryRepository {
    Delivery findDeliveryByReference(String referenceNumber);
    void save(Delivery delivery);
}
