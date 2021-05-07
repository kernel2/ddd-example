package fr.victorianfashion.api.domain.sales.cart;

public interface Entity<T> {

  // Entities compare by identity, not by attributes.
  boolean sameIdentityAs(T other);
}
