package fr.victorianfashion.api.domain.sales.shipping;

import java.util.Objects;

public class Address {

  private final String line1;
  private final String city;

  public Address(String line1, String city) {
    this.line1 = line1;
    this.city = city;
  }

  public String getLine1() {
    return line1;
  }

  public String getCity() {
    return city;
  }

  @Override
  public String toString() {
    return "Address{" + "line1='" + line1 + '\'' + ", city='" + city + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(line1, address.line1) && Objects.equals(city, address.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line1, city);
  }
}
