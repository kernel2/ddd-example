package fr.victorianfashion.api.use_cases.sales;

public interface Entity<T> {

  // Entities compare by identity, not by attributes.
  boolean sameIdentityAs(T other);
}
