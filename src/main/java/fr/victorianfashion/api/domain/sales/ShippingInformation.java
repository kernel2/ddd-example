package fr.victorianfashion.api.domain.sales;

public class ShippingInformation {
  private Address address;

  public ShippingInformation(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }
}
