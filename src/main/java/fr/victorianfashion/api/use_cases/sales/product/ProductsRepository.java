package fr.victorianfashion.api.use_cases.sales.product;

import fr.victorianfashion.api.domain.sales.product.Product;
import java.util.Optional;

public interface ProductsRepository {
  Optional<Product> findAllProduct();

  Product findProductById(Long id);
}