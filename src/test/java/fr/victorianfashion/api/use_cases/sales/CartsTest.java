// package fr.victorianfashion.api.use_cases.sales;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import fr.victorianfashion.api.domain.product.InvalidException;
// import fr.victorianfashion.api.domain.product.Price;
// import fr.victorianfashion.api.domain.product.Product;
// import java.math.BigDecimal;
// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
//
// @ExtendWith(MockitoExtension.class)
// public class CartsTest {
//
//  private ProductToCart productToCart;
//
//  @Mock private ICartRepository cartsRepository;
//  @Mock private ProductsRepository productsRepository;
//
//  @BeforeEach
//  public void init() {
//    productToCart = new ProductToCart(productsRepository,cartsRepository);
//  }
//
//  @Test
//  void find_all_items_in_cart() {
//    Assertions.assertThat(productToCart.getAllProductInCart()).isNull();
//  }
//
//
//    @Test
//    void item_is_added() throws InvalidException {
//      Product product = new Product(
//          "product1",
//          "product 1 description",
//          new Price(new BigDecimal(132.34)),
//          "available",
//          1000L);
//      Cart cart = new Cart(product, "item1", 2);
//      Cart result = productToCart.extractedExecute(1000L,product,cart);
//      assertThat(result.getProductId().getId()).isEqualTo(cart.getProductId().getId());
//      assertThat(result).isNotNull();
//    }
//
//
//    @Test
//    void item_is_removed() {
//    Assertions.assertThat(productToCart.removeItemsByPID(1000L)).isTrue();
//    }
//
//
// }
