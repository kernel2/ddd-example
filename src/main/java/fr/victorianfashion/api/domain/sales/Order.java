package fr.victorianfashion.api.domain.sales;

import java.util.List;

public class Order {

  private List<Product> products;
  private ShippingInformation shippingInformation;

  public Order(List<Product> products, ShippingInformation shippingInformation) {

    this.products = products;
    this.shippingInformation = shippingInformation;
  }

  public List<Product> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "Order{" + "products=" + products + '}';
  }
}
