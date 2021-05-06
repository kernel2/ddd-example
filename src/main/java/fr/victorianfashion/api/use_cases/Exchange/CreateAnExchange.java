package fr.victorianfashion.api.use_cases.Exchange;

import fr.victorianfashion.api.domain.Exchange.Exchange;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.user;
import fr.victorianfashion.api.use_cases.User.UserRepository;
import fr.victorianfashion.api.use_cases.product.Products;

public class CreateAnExchange {
    private final Products products;
    private final UserRepository users;
    private final ExchangeRepository exchanges;

    public CreateAnExchange(ExchangeRepository exchanges,Products products, UserRepository users) {
        this.products = products;
        this.users = users;
        this.exchanges = exchanges;
    }

    public Exchange create(Long userID, Long productID){
        Product product = products.findProductById(productID);
        user creator = users.findById(userID);
        Exchange exchange = new Exchange();
        exchange.setMaker(creator);
        exchange.setMakerOffer(product);
        exchanges.save(exchange);
        return exchange;
    }

}
