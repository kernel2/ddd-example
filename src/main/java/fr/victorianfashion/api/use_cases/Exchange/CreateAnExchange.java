//package fr.victorianfashion.api.use_cases.Exchange;
//
//import fr.victorianfashion.api.domain.Exchange.Exchange;
//import fr.victorianfashion.api.domain.product.Product;
//import fr.victorianfashion.api.domain.user;
//import fr.victorianfashion.api.use_cases.User.UserRepository;
//
//public class CreateAnExchange {
//  private final Product product;
//  private final UserRepository users;
//  private final ExchangeRepository exchanges;
//  private final ProductsRepository productsRepository;
//
//  public CreateAnExchange(
//      ExchangeRepository exchanges,
//      Product product,
//      UserRepository users,
//      ProductsRepository productsRepository) {
//    this.product = product;
//    this.users = users;
//    this.exchanges = exchanges;
//    this.productsRepository = productsRepository;
//  }
//
//  public Exchange create(Long userID, Long productID) {
//    Product product = productsRepository.findProductById(productID);
//    user creator = users.findById(userID);
//    Exchange exchange = new Exchange();
//    exchange.setMaker(creator);
//    exchange.setMakerOffer(product);
//    exchange.setState("open");
//    exchanges.save(exchange);
//    return exchange;
//  }
//}
