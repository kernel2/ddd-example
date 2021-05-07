package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.product.Order;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.sales.shipping.Address;
import fr.victorianfashion.api.domain.sales.shipping.ShippingInformation;

public class Shipper {

  public void ship(ShippingInformation shippingInformation, Order order) {
    order
        .getProducts()
        .forEach(
            product ->
                shipInternal(product, shippingInformation.getAddress(), product.getWeightInGms()));
  }

  private void shipInternal(Product product, Address address, Double weightInGrams) {
    // does some stuff with weight, decides packet type etc
    System.out.println(
        "Product Name: "
            + product.getName()
            + "Address: "
            + address
            + " with weight: "
            + weightInGrams);
  }
}
