package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.product.InvalidException;
import fr.victorianfashion.api.domain.product.Price;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.sales.Cart;
import fr.victorianfashion.api.use_cases.CartsRepository;
import fr.victorianfashion.api.use_cases.ProductsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeCarts implements CartsRepository {

  private final ProductsRepository productsRepository;
  private final CartsRepository cartsRepository;
  private final Map<String, List<Cart>> items;
  List<Cart> cartList = new ArrayList<>();

  public FakeCarts(ProductsRepository productsRepository,
      CartsRepository cartsRepository) throws InvalidException {
    this.productsRepository = productsRepository;
    this.cartsRepository = cartsRepository;
    items = new HashMap<>();

    cartList.add(
        new Cart(
            new Product(
                "product1",
                "product 1 description",
                new Price(new BigDecimal(10000), Currency.getInstance("INR")),
                "available",
                1000L),
            "item1",
            2));
    cartList.add(
        new Cart(
            new Product(
                "product2",
                "product 2 description",
                new Price(new BigDecimal(103.34),  Currency.getInstance("INR")),
                "available",
                1001L),
            "item1",
            3));
    cartList.add(
        new Cart(
            new Product(
                "product3",
                "product 3 description",
                new Price(new BigDecimal(452.34),  Currency.getInstance("INR")),
                "available",
                1002L),
            "item1",
            6));
    cartList.add(
        new Cart(
            new Product(
                "product4",
                "product 4 description",
                new Price(new BigDecimal(1312.34),  Currency.getInstance("INR")),
                "available",
                1003L),
            "item1",
            7));
    cartList.add(
        new Cart(
            new Product(
                "product5",
                "product 5 description",
                new Price(new BigDecimal(2142.34),  Currency.getInstance("INR")),
                "available",
                1004L),
            "item1",
            7));
    cartList.add(
        new Cart(
            new Product(
                "product6",
                "product 6 description",
                new Price(new BigDecimal(1325.34),  Currency.getInstance("INR")),
                "available",
                1005L),
            "item1",
            4));

    items.put("cart1", cartList);
  }

  @Override
  public Cart save(Cart cart) {
      //Cart cartSave = cartList.add(cart);
      return cartsRepository.save(cart);
  }

  @Override
  public List<Cart> findAll() {
    return items.values().stream().findAny().orElse(null);
  }

  @Override
  public Cart findProductByIdToCart(Long id) {
    Product productId = productsRepository.findProductById(id);
    Cart cart = cartList.stream().filter(pid -> pid.getProductId().equals(productId)).findAny().orElse(null);
    return cart;
  }

}
