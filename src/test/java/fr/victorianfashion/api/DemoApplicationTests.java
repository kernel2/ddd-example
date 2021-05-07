package fr.victorianfashion.api;

import fr.victorianfashion.api.domain.sales.cart.Cart;
import fr.victorianfashion.api.domain.sales.product.Item;
import fr.victorianfashion.api.domain.sales.product.Order;
import fr.victorianfashion.api.domain.sales.product.Price;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.sales.shipping.Address;
import fr.victorianfashion.api.domain.sales.shipping.ShippingInformation;
import fr.victorianfashion.api.use_cases.sales.CreateOrder;
import fr.victorianfashion.api.use_cases.sales.ProductToCart;
import fr.victorianfashion.api.use_cases.sales.Shipper;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void contextLoads() {

    ProductToCart productToCart = new ProductToCart();

    Product dress1 =
        new Product(
            "PROENZA SCHOULER dress",
            new Price(new BigDecimal(10000), Currency.getInstance("EUR")),
            20.0);
    Item dress1Item = new Item(dress1, 1);
    productToCart.addItem(dress1Item);

    Product dress2 =
        new Product(
            "ETRO dress", new Price(new BigDecimal(120), Currency.getInstance("EUR")), 20.0);
    Item dress2Item = new Item(dress2, 1);
    productToCart.addItem(dress2Item);

    Product dress3 =
        new Product(
            "ZIMMERMANN dress", new Price(new BigDecimal(1100), Currency.getInstance("EUR")), 20.0);
    Item dress3Item = new Item(dress3, 2);
    productToCart.addItem(dress3Item);

    Product dressToBeRemoved =
        new Product(
            "Stretch-linen shirt dress",
            new Price(new BigDecimal(10000), Currency.getInstance("EUR")),
            20.0);
    Item dressToBeRemovedItem = new Item(dressToBeRemoved, 1);
    var result = productToCart.removeItem(dressToBeRemovedItem);

    System.out.println("Cart now has " + result);

    // Use case 6
    Cart cart1 = new Cart();

    Cart cart2 = new Cart();

    System.out.println("cart1 and cart 2 are different? = " + !cart1.equals(cart2));

    System.out.println("cart1 and cart 2 are different? = " + !cart1.sameIdentityAs(cart2));

    Product product1 =
        new Product(
            "Stretch-linen shirt dress",
            new Price(new BigDecimal(10000), Currency.getInstance("EUR")),
            20.0);
    Product product2 =
        new Product(
            "ZIMMERMANN dress", new Price(new BigDecimal(3000), Currency.getInstance("EUR")), 20.0);

    System.out.println("product1 can be replaced by product2 = " + product1.sameValueAs(product2));

    productToCart.checkOut();

    ShippingInformation shippingInformation =
        new ShippingInformation(new Address("129 Rue de Grenelle, 75007 Paris", "paris"));
    CreateOrder createOrder = new CreateOrder();
    Order order = createOrder.create(productToCart, shippingInformation);

    System.out.println("order has these products = " + order.getProducts());

    // order.ship();

    Shipper shipper = new Shipper();
    shipper.ship(shippingInformation, order);
  }
}
