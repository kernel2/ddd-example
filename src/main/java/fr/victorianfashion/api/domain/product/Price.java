package fr.victorianfashion.api.domain.product;

import java.math.BigDecimal;

public class Price {
  private final BigDecimal price;

  public Price(BigDecimal price) throws InvalidException {
    if (price.compareTo(BigDecimal.ZERO) == 0) {
      throw new InvalidException("Price is not valid");
    }
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
