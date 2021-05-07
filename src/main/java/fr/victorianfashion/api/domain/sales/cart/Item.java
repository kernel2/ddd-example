package fr.victorianfashion.api.domain.sales.cart;

import fr.victorianfashion.api.domain.sales.product.Product;
import java.util.Objects;

public class Item {

  private Product product;
  private int quantity;
  private CatalogItem catalogItem;

  public Item(Product product, int quantity) {

    this.product = product;
    this.quantity = quantity;
  }

  public boolean isQtyWithinAllowedLimit() {
    return this.quantity <= catalogItem.getMaxAllowedPurchaseQty() ? true : false;
    // cart can't have more than max qty defined at catalog level.
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return quantity == item.quantity && product.equals(item.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }

  @Override
  public String toString() {
    return "Item{" + "product=" + product + ", quantity=" + quantity + '}';
  }
}
