package fr.victorianfashion.api;

import fr.victorianfashion.api.domain.sales.Address;
import fr.victorianfashion.api.domain.sales.Cart;
import fr.victorianfashion.api.domain.sales.Item;
import fr.victorianfashion.api.domain.sales.Order;
import fr.victorianfashion.api.domain.sales.Price;
import fr.victorianfashion.api.domain.sales.Product;
import fr.victorianfashion.api.domain.sales.ShippingInformation;
import fr.victorianfashion.api.use_cases.sales.OrderFactory;
import fr.victorianfashion.api.use_cases.sales.ProductToCart;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void contextLoads() {

    ProductToCart productToCart = new ProductToCart();
    Cart cart = new Cart();

    Product ipadPro = new Product("Ipad Pro", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);
    Item ipadProItem = new Item(ipadPro, 1);
    productToCart.addItem(ipadProItem);

    Product inkPen = new Product("Hero Ink Pen", new Price(new BigDecimal(120), Currency.getInstance("INR")), 20.0);
    Item inkPenItem = new Item(inkPen, 1);
    productToCart.addItem(inkPenItem);

    Product bat = new Product("GM Cricket Bat", new Price(new BigDecimal(3000), Currency.getInstance("INR")), 20.0);
    Item batItem = new Item(bat, 2);
    productToCart.addItem(batItem);

    Product ipadProToBeRemoved = new Product("Ipad Pro", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);
    Item ipadProToBeRemovedItem = new Item(ipadProToBeRemoved, 1);
    productToCart.removeItem(ipadProToBeRemovedItem);

    //Use case 6
    Cart cart1 = new Cart();

    Cart cart2 = new Cart();

    System.out.println("cart1 and cart 2 are different? = " + !cart1.equals(cart2));

    System.out.println("cart1 and cart 2 are different? = " + !cart1.sameIdentityAs(cart2));

    Product inkPen1 = new Product("Hero Ink Pen", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);
    Product inkPen2 = new Product("Hero Ink Pen", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);

    System.out.println("inkPen1 can be replaced by inkPen2 = "+ inkPen1.sameValueAs(inkPen2) );

    productToCart.checkOut();

    ShippingInformation shippingInformation = new ShippingInformation(new Address("line1", "Pune"));
    Order order = OrderFactory.create(productToCart, shippingInformation);

    System.out.println("order has these products = " + order.getProducts());

    order.ship();

    // Shipper.ship(new ShippingInformation(new Address("line1", "Pune")), order);

  }
}
