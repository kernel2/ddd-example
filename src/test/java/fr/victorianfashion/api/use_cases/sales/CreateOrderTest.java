package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.product.Item;
import fr.victorianfashion.api.domain.sales.product.Order;
import fr.victorianfashion.api.domain.sales.product.Price;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.sales.shipping.Address;
import fr.victorianfashion.api.domain.sales.shipping.ShippingInformation;
import java.math.BigDecimal;
import java.util.Currency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateOrderTest {
  ProductToCart product = new ProductToCart();
  CreateOrder createOrder = new CreateOrder();

  @BeforeEach
  public void init() {
    createOrder = new CreateOrder();
    product = new ProductToCart();
  }

  @Test
  void created_order() {
    Product dress1 = new Product("PROENZA SCHOULER dress", new Price(new BigDecimal(10000), Currency.getInstance("EUR")), 20.0);
    Item dress1Item = new Item(dress1, 1);
    product.addItem(dress1Item);

    Product dress2 = new Product("ETRO dress", new Price(new BigDecimal(120), Currency.getInstance("EUR")), 20.0);
    Item dress2Item = new Item(dress2, 1);
    product.addItem(dress2Item);

    ShippingInformation shippingInformation = new ShippingInformation(new Address("129 Rue de Grenelle, 75007 Paris", "paris"));

    Assertions.assertThat(createOrder.create(product,shippingInformation)).isNotNull();
  }

}
