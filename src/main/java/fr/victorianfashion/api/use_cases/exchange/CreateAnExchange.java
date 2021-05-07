package fr.victorianfashion.api.use_cases.exchange;

import fr.victorianfashion.api.domain.exchange.Exchange;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.user.User;
import fr.victorianfashion.api.use_cases.sales.product.ProductsRepository;
import fr.victorianfashion.api.use_cases.user.UserRepository;

public class CreateAnExchange {
  private final Product product;
  private final UserRepository users;
  private final ExchangeRepository exchanges;
  private final ProductsRepository productsRepository;

  public CreateAnExchange(
      ExchangeRepository exchanges,
      Product product,
      UserRepository users,
      ProductsRepository productsRepository) {
    this.product = product;
    this.users = users;
    this.exchanges = exchanges;
    this.productsRepository = productsRepository;
  }

  public Exchange create(Long userID, Long productID) {
    Product product = productsRepository.findProductById(productID);
    User creator = users.findById(userID);
    Exchange exchange = new Exchange();
    exchange.setMaker(creator);
    exchange.setMakerOffer(product);
    exchange.setState("open");
    exchanges.save(exchange);
    return exchange;
  }
}
