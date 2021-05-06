package fr.victorianfashion.api.use_cases.product;

import fr.victorianfashion.api.domain.product.InvalidException;
import fr.victorianfashion.api.domain.product.Price;
import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.use_cases.ProductsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeProduct implements ProductsRepository {
  List<Product> productList = new ArrayList<>();

  public FakeProduct() throws InvalidException {

    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1000L));
    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1001L));
    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1002L));
    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1003L));
    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1004L));
    productList.add(
        new Product(
            "product1",
            "product 1 description",
            new Price(new BigDecimal(132.34)),
            "available",
            1005L));
  }

  @Override
  public Optional<Product> findAllProduct() {
    return productList.stream().findAny();
  }

  @Override
  public Product findProductById(Long id) {
    return (Product)
        productList.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
  }
}
