package fr.victorianfashion.api.domain.sales.cart;

import fr.victorianfashion.api.domain.sales.DomainEvent;
import java.util.List;

public class CartCheckedOut implements DomainEvent {
  private List<CartItem> items;

  public CartCheckedOut(List<CartItem> items) {
    this.items = items;
  }

  public List<CartItem> getItems() {
    return items;
  }
}
