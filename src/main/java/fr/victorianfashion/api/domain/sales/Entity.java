package fr.victorianfashion.api.domain.sales;

public interface Entity<T> {

  // Entities compare by identity, not by attributes.
  boolean sameIdentityAs(T other);
}
