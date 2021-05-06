package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.product.InvalidException;
import fr.victorianfashion.api.domain.product.Price;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.sales.Cart;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartsTest {
  private Carts carts;

  @BeforeEach
  public void init() throws InvalidException {
    carts = new FakeCarts();
  }

  @Test
  void should_find_all_product_in_cart() {
    Assertions.assertThat(carts.items()).isNotNull();
  }

  @Test
  void item_is_added() throws InvalidException {
    Cart cartItem = new Cart(
            new Product(
                "product1",
                "product 1 description",
                new Price(new BigDecimal(132.34)),
                "available",
                1011L),
            "item1",
            2);
    Assertions.assertThat(carts.addToCart(cartItem)).isTrue();
  }

  @Test
  void item_is_removed() {
    Assertions.assertThat(carts.removeProductByPID(1001L)).isFalse();
  }

  @Test
  void cart_is_emptied() {
    Assertions.assertThat(carts.cartEmpty()).isFalse();
    Assertions.assertThat(carts.cartEmpty()).isNotNull();
  }


}
