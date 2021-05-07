package fr.victorianfashion.api.domain.sales.product;

import java.util.Objects;
//Aggregate root
public class Product implements ValueObject<Product> {

  private final String name;

  private final Price price;
  private final Double weightInGrams;

  public Product(String name, Price price, Double weightInGrams) {
    this.name = name;
    this.price = price;
    this.weightInGrams = weightInGrams;
  }

  public String getName() {
    return name;
  }

  public Price getPrice() {
    return price;
  }

  public Double getWeightInGms() {
    return weightInGrams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return name.equals(product.name) && price.equals(product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }

  @Override
  public String toString() {
    return "Product{" + "name='" + name + '\'' + ", price=" + price + '}';
  }

  @Override
  public boolean sameValueAs(Product o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return name.equals(o.name) && price.equals(o.price);
  }
}
