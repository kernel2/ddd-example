package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.Cart;

public interface Carts {
  Cart id();

  Cart items();

  void addProductToCartByPID(Long pid);

  Cart getProductByProductID(Long pid);

  boolean addToCart(Cart cartItems);

  boolean removeProductByPID(Long productId);

  boolean cartEmpty();
}
