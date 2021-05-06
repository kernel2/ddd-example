package fr.victorianfashion.api.domain.sales;

import fr.victorianfashion.api.domain.product.Product;
import java.util.Objects;

public class Cart {

  private final Product productId;
  private final String title;
  private final int quantity;

  public Cart(Product productId, String title, int quantity) {
    this.productId = productId;
    this.title = title;
    this.quantity = quantity;
  }

  public Product getProductId() {
    return productId;
  }

  public String getTitle() {
    return title;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cart)) {
      return false;
    }
    Cart cart = (Cart) o;
    return getQuantity() == cart.getQuantity()
        && Objects.equals(getProductId(), cart.getProductId())
        && Objects.equals(getTitle(), cart.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProductId(), getTitle(), getQuantity());
  }

  @Override
  public String toString() {
    return "Cart{"
        + "productId="
        + productId
        + ", title='"
        + title
        + '\''
        + ", quantity="
        + quantity
        + '}';
  }
}
