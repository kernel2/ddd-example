package fr.victorianfashion.api.domain.sales.shipping;

import java.util.Objects;

public class ShippingInformation {
  private final Address address;

  public ShippingInformation(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ShippingInformation)) {
      return false;
    }
    ShippingInformation that = (ShippingInformation) o;
    return Objects.equals(getAddress(), that.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAddress());
  }

  @Override
  public String toString() {
    return "ShippingInformation{" + "address=" + address + '}';
  }
}
