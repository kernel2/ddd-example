package fr.victorianfashion.api.use_cases.sales;

// A value object DDD

public interface ValueObject<T> {

  // ValueObjects se comparent par les valeurs de leurs attributs, ils n'ont pas d'identité.
  boolean sameValueAs(T other);
}
