package fr.victorianfashion.api.use_cases.product;

import fr.victorianfashion.api.domain.product.Product;
import java.util.Optional;

public interface Products {
  Optional<Product> findAllProduct();

  Product findProductById(Long id);
}
