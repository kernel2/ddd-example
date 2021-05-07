package fr.victorianfashion.api.use_cases.sales;

import static org.assertj.core.api.Assertions.assertThat;

import fr.victorianfashion.api.domain.sales.product.Item;
import fr.victorianfashion.api.domain.sales.product.Price;
import fr.victorianfashion.api.domain.sales.product.Product;
import java.math.BigDecimal;
import java.util.Currency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductToCartTest {

  private ProductToCart productToCart;

  @BeforeEach
  public void init() {
    productToCart = new ProductToCart();
  }

  @Test
  void find_all_items_in_cart() {
    Assertions.assertThat(productToCart.allItems()).isNotNull();
  }

  @Test
  void item_is_added() {

    Product dress1 =
        new Product(
            "PROENZA SCHOULER dress",
            new Price(new BigDecimal(10000), Currency.getInstance("EUR")),
            20.0);
    Item dress1Item = new Item(dress1, 1);

    var result = productToCart.addItem(dress1Item);
    assertThat(result).isEqualTo(dress1Item);

    assertThat(result).isNotNull();
  }

  @Test
  void item_is_removed() {
    Product dressToBeRemoved =
        new Product(
            "Stretch-linen shirt dress",
            new Price(new BigDecimal(10000), Currency.getInstance("EUR")),
            20.0);
    Item dressToBeRemovedItem = new Item(dressToBeRemoved, 1);

    var result = productToCart.removeItem(dressToBeRemovedItem);
    assertThat(result).isEqualTo("item has been removed");
    assertThat(result).isEqualTo(result);
  }

  @Test
  void item_checkOut() {
    //    Product dress1 = new Product("PROENZA SCHOULER dress", new Price(new BigDecimal(10000),
    // Currency.getInstance("EUR")), 20.0);
    //    Item dress1Item = new Item(dress1, 1);
    //    Product dress2 = new Product("ETRO dress", new Price(new BigDecimal(120),
    // Currency.getInstance("EUR")), 20.0);
    //    Item dress2Item = new Item(dress2, 1);

    //    var result = productToCart.checkOut();
    //
    //    assertThat(result).isEqualTo(Status.CHECKEDOUT);
  }
}
