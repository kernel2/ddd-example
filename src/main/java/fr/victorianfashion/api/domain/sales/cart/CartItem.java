package fr.victorianfashion.api.domain.sales.cart;

import fr.victorianfashion.api.domain.sales.product.Price;
import java.util.Objects;

public class CartItem {
  private final String name;
  private final Price price;
  private final int quantity;

  public CartItem(String name, Price price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CartItem)) {
      return false;
    }
    CartItem cartItem = (CartItem) o;
    return quantity == cartItem.quantity && Objects.equals(name, cartItem.name)
        && Objects.equals(price, cartItem.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, quantity);
  }
}
