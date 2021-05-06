package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.product.InvalidException;
import fr.victorianfashion.api.domain.product.Price;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.sales.Cart;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeCarts implements Carts {

  private final Map<String, List<Cart>> items;
  List<Cart> cartList = new ArrayList<>();

  public FakeCarts() throws InvalidException {
    items = new HashMap<>();

    cartList.add(
        new Cart(
            new Product(
                "product1",
                "product 1 description",
                new Price(new BigDecimal(132.34)),
                "available",
                1000L),
            "item1",
            2));
    cartList.add(
        new Cart(
            new Product(
                "product2",
                "product 2 description",
                new Price(new BigDecimal(103.34)),
                "available",
                1001L),
            "item1",
            3));
    cartList.add(
        new Cart(
            new Product(
                "product3",
                "product 3 description",
                new Price(new BigDecimal(452.34)),
                "available",
                1002L),
            "item1",
            6));
    cartList.add(
        new Cart(
            new Product(
                "product4",
                "product 4 description",
                new Price(new BigDecimal(1312.34)),
                "available",
                1003L),
            "item1",
            7));
    cartList.add(
        new Cart(
            new Product(
                "product5",
                "product 5 description",
                new Price(new BigDecimal(2142.34)),
                "available",
                1004L),
            "item1",
            7));
    cartList.add(
        new Cart(
            new Product(
                "product6",
                "product 6 description",
                new Price(new BigDecimal(1325.34)),
                "available",
                1005L),
            "item1",
            4));

    items.put("cart1", cartList);
  }

  @Override
  public Cart id() {
    return id();
  }

  @Override
  public Cart items() {
    return cartList.stream().findAny().orElse(null);
  }


  @Override
  public boolean addItemsToCartByPID(Long pid) {
    Cart productToCart = getItemsByItemsId(pid);
    return addToCart(productToCart);
  }

  @Override
  public Cart getItemsByItemsId(Long id) {
    return cartList.stream().filter(c -> c.getProductId().getId().equals(id)).findAny().orElse(null);
  }

  @Override
  public boolean addToCart(Cart cartItems) {
    return cartList.add(cartItems);
  }

  @Override
  public boolean removeItemsByPID(Long productId) {
    Cart prod = getItemsByItemsId(productId);
    return cartList.remove(prod);
  }

  @Override
  public boolean cartEmpty() {
    return cartList.isEmpty();
  }
}
