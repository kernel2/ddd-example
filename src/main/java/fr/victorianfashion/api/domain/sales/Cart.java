package fr.victorianfashion.api.domain.sales;

import fr.victorianfashion.api.use_cases.sales.Entity;
import java.util.Objects;
import java.util.UUID;

public class Cart implements Entity {

  private final UUID id;

  public Cart() {
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cart cart = (Cart) o;
    return id.equals(cart.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean sameIdentityAs(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cart cart = (Cart) o;
    return id.equals(cart.id);
  }
}
