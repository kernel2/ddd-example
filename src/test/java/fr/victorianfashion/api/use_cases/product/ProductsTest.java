package fr.victorianfashion.api.use_cases.product;

import fr.victorianfashion.api.domain.product.InvalidException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTest {

  private Products products;

  @BeforeEach
  public void init() throws InvalidException {
    products = new FakeProduct();
  }

  @Test
  void should_find_product_by_id() throws InvalidException {
    Assertions.assertThat(products.findProductById(1000L)).isNotNull();
    Assertions.assertThat(products.findProductById(1000L).getId()).isEqualTo(1000L);
  }

  @Test
  void should_find_all_products() {
    Assertions.assertThat(products.findAllProduct()).isNotEmpty();
  }
}
