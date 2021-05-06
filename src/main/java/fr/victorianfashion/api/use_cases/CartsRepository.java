package fr.victorianfashion.api.use_cases;

import fr.victorianfashion.api.domain.sales.Cart;
import java.util.List;

public interface CartsRepository {

  Cart save(Cart cart);

  List<Cart> findAll();

  Cart findProductByIdToCart(Long id);

}
