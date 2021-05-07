package fr.victorianfashion.api.use_cases.Exchange;

import fr.victorianfashion.api.domain.Delivery.Delivery;
import fr.victorianfashion.api.domain.Exchange.Exchange;
import fr.victorianfashion.api.use_cases.Delivery.DeliveryRepository;

public class SendApprovalOffer {
    private ExchangeRepository exchanges;
    private DeliveryRepository deliveries;

    public SendApprovalOffer(ExchangeRepository exchanges, DeliveryRepository deliveries) {
        this.exchanges = exchanges;
        this.deliveries = deliveries;
    }

    public Exchange send(Long ExchangeId, String referenceNumber){
        Exchange exchange = exchanges.findExchangeByID(ExchangeId);
        Delivery delivery = deliveries.findDeliveryByReference(referenceNumber);
        exchange.setApprovedProposalDelivery(delivery);
        exchanges.save(exchange);
        return exchange;
    }
}
