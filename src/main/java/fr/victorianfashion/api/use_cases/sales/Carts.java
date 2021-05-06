package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.Cart;

public interface Carts {
  Cart id();

  Cart items();

  boolean addItemsToCartByPID(Long id);

  Cart getItemsByItemsId(Long id);

  boolean addToCart(Cart cartItems);

  boolean removeItemsByPID(Long productId);

  boolean cartEmpty();
}
