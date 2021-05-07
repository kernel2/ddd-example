package fr.victorianfashion.api.domain.sales;

import java.util.List;

public class Order {

  private List<Product> products;
  private ShippingInformation shippingInformation;

  public Order(List<Product> products, ShippingInformation shippingInformation) {

    this.products = products;
    this.shippingInformation = shippingInformation;
  }

  private static void shipInternal(Product product, Address address, Double weightInGrams) {
    // does some stuff with weight, decides packet type etc
    System.out.println("Shipped =  " + product.getName() + " with weight " + weightInGrams);
  }

  public List<Product> getProducts() {
    return products;
  }

  public void ship() {

    products.forEach(
        product ->
            shipInternal(product, shippingInformation.getAddress(), product.getWeightInGms()));
  }

  @Override
  public String toString() {
    return "Order{" + "products=" + products + '}';
  }
}
