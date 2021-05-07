package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.product.Item;
import fr.victorianfashion.api.domain.sales.product.Order;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.sales.shipping.ShippingInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateOrder {

  public Order create(ProductToCart cart, ShippingInformation shippingInformation) {
    List<Item> items = cart.allItems();

    List<Product> products =
        items.stream()
            .map(
                item -> {
                  int quantity = item.getQuantity();
                  List<Product> tempProducts = new ArrayList<>();
                  while (quantity > 0) {
                    tempProducts.add(item.getProduct());
                    quantity--;
                  }
                  return tempProducts;
                })
            .flatMap(List::stream)
            .collect(Collectors.toList());

    return new Order(products, shippingInformation);
  }
}
