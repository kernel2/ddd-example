package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.product.InvalidException;
import fr.victorianfashion.api.domain.product.Price;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.sales.Cart;
import fr.victorianfashion.api.use_cases.ProductToCart;
import fr.victorianfashion.api.use_cases.CartsRepository;
import fr.victorianfashion.api.use_cases.ProductsRepository;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartsTest {

  private FakeCarts fakeCarts;

  @Mock private CartsRepository cartsRepository;
  @Mock private ProductsRepository productsRepository;

  @BeforeEach
  public void init() throws InvalidException {
    fakeCarts = new FakeCarts(productsRepository,cartsRepository);
  }

  @Test
  void find_all_items_in_cart() {
    Assertions.assertThat(fakeCarts.findAll()).isNull();
  }

  @Nested
  class CreateProductToCartShould {

    @Test
    void return_save_and_return_saved_cart() throws InvalidException {
      // Given
      Cart cart = new Cart(
              new Product(
                  "product1",
                  "product 1 description",
                  new Price(new BigDecimal(132.34)),
                  "available",
                  1000L),
          "item1", 2);

      when(cartsRepository.save(cart)).thenReturn(cart);
      // When
      Cart result = fakeCarts.findProductByIdToCart(1000L);
      // Then
      assertThat(result).isEqualTo(cart);
    }
  }

  //
  //  @Test
  //  void item_is_added() throws InvalidException {
  //    Cart cartItem = new Cart(
  //            new Product(
  //                "product1",
  //                "product 1 description",
  //                new Price(new BigDecimal(132.34)),
  //                "available",
  //                1011L),
  //            "item1",
  //            2);
  //    Assertions.assertThat(cartsRepository.(cartItem)).isTrue();
  //  }
  //
  //  @Test
  //  void item_is_added_To_Cart_By_ID() throws InvalidException {
  //    Cart cartItem = new Cart(
  //        new Product(
  //            "product1",
  //            "product 1 description",
  //            new Price(new BigDecimal(132.34)),
  //            "available",
  //            1011L),
  //        "item1",
  //        2);
  //
  // Assertions.assertThat(cartsRepository.addItemsToCartByPID(cartItem.getProductId().getId())).isTrue();
  //  }
  //
  //
  //  @Test
  //  void get_Items_By_ItemsId() {
  //
  // Assertions.assertThat(cartsRepository.getItemsByItemsId(1000L).getProductId().getId()).isNotNull();
  //  }
  //
  //
  //  @Test
  //  void item_is_removed() {
  //    Assertions.assertThat(cartsRepository.removeItemsByPID(1001L)).isTrue();
  //  }
  //
  //  @Test
  //  void cart_is_emptied() {
  //    Assertions.assertThat(cartsRepository.cartEmpty()).isFalse();
  //    Assertions.assertThat(cartsRepository.cartEmpty()).isNotNull();
  //  }

}
