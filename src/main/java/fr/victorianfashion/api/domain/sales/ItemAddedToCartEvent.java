package fr.victorianfashion.api.domain.sales;

import fr.victorianfashion.api.use_cases.sales.DomainEvent;

public class ItemAddedToCartEvent implements DomainEvent {
  private String name;

  private Price price;

  private int quantity;

  public ItemAddedToCartEvent(String name, Price price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public Price getPrice() {
    return price;
  }
}
