package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.CartItem;
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
