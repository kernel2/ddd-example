package fr.victorianfashion.api.domain.product;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price {
  private final BigDecimal price;
  private final Currency currency;

  public Price(BigDecimal price, Currency currency) throws InvalidException {
    if (price.compareTo(BigDecimal.ZERO) == 0) {
      throw new InvalidException("Price is not valid");
    }
    this.price = price;
    this.currency = currency;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (!(o instanceof Price)) {
      return false;
    }
    Price price1 = (Price) o;
    return Objects.equals(getPrice(), price1.getPrice())
        && Objects.equals(currency, price1.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice(), currency);
  }

  @Override
  public String toString() {
    return "Price{" + "price=" + price + ", currency=" + currency + '}';
  }
}
