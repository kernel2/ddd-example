package fr.victorianfashion.api.domain.sales;

import fr.victorianfashion.api.use_cases.sales.DomainEvent;

public class ItemRemovedFromCartEvent implements DomainEvent {
  private String name;

  public ItemRemovedFromCartEvent(String name) {

    this.name = name;
  }

  public String getName() {
    return name;
  }
}
