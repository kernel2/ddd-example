 package fr.victorianfashion.api.use_cases.sales;

 import static org.assertj.core.api.Assertions.assertThat;

 import fr.victorianfashion.api.domain.sales.Item;
 import fr.victorianfashion.api.domain.sales.Price;
 import fr.victorianfashion.api.domain.sales.Product;
 import java.math.BigDecimal;
 import java.util.Currency;
 import org.assertj.core.api.Assertions;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 public class CartsTest {

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

      Product ipadPro = new Product("Ipad Pro", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);
      Item ipadProItem = new Item(ipadPro, 1);

      var result = productToCart.addItem(ipadProItem);
      assertThat(result).isEqualTo(ipadProItem);
      assertThat(result).isNotNull();
    }


    @Test
    void item_is_removed() {
      Product ipadProToBeRemoved = new Product("Ipad Pro", new Price(new BigDecimal(10000), Currency.getInstance("INR")), 20.0);
      Item ipadProToBeRemovedItem = new Item(ipadProToBeRemoved, 1);

      var result = productToCart.removeItem(ipadProToBeRemovedItem);
      assertThat(result.getProduct()).isEqualTo(ipadProToBeRemovedItem.getProduct());
      assertThat(result.getProduct()).isNull();
    }


 }
