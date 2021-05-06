package fr.victorianfashion.api.use_cases;

import fr.victorianfashion.api.domain.product.Product;
import java.util.Optional;

public interface ProductsRepository {
  Optional<Product> findAllProduct();

  Product findProductById(Long id);
}
