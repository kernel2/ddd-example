package fr.victorianfashion.api.domain.product;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

// Product root
public class Product {
  private final String name;
  private final String description;
  private final Price price;
  private final String stock;
  private Long id;

  public Product() throws InvalidException {
    this.name = "default name";
    this.description = "description";
    this.price = new Price(new BigDecimal(000.000),  Currency.getInstance("INR"));
    this.stock = "none";
    this.id = 0L;
  }

  public Product(String name, String description, Price price, String stock, Long id) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Price getPrice() {
    return price;
  }

  public String getStock() {
    return stock;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(name, product.name)
        && Objects.equals(description, product.description)
        && Objects.equals(price, product.price)
        && Objects.equals(stock, product.stock)
        && Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, stock, id);
  }

  @Override
  public String toString() {
    return "Product{"
        + "name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", price="
        + price
        + ", stock="
        + stock
        + ", id="
        + id
        + '}';
  }
}
