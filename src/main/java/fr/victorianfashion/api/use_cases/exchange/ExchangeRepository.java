package fr.victorianfashion.api.use_cases.exchange;

import fr.victorianfashion.api.domain.exchange.Exchange;

public interface ExchangeRepository {
  void save(Exchange exchange);

  Exchange findExchangeByID(Long id);
}
