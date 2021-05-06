package fr.victorianfashion.api.use_cases;

import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.sales.Cart;
import java.util.ArrayList;
import java.util.List;

public class ProductToCart {
  private final ProductsRepository products;
  private final CartsRepository carts;
  private final List<Cart> cartList = new ArrayList<>();

  public ProductToCart(ProductsRepository products, CartsRepository carts) {
    this.products = products;
    this.carts = carts;
  }

  public Cart getAllProductInCart() {
    List<Cart> listCart = carts.findAll();
    return listCart.stream().findAny().orElse(null);
  }

  public Cart addItemsToCartById(Long pid) {
    Product product = products.findProductById(pid);
    Cart cart = carts.findProductByIdToCart(product.getId());

    extractedExecute(pid, product, cart);

    carts.save(cart);
    return cart;
  }

  public Cart extractedExecute(Long pid, Product product, Cart cart) {
    if (product.getId().equals(pid)){
       cartList.add(cart);
    }else
    {
      new RessourceNotFoundException("not found item");
    }
    return cart;
  }

  public void removeItemsByPID(Long productId) {
    Product product = products.findProductById(productId);
    Cart removeProduct = carts.findProductByIdToCart(product.getId());
    cartList.remove(removeProduct);
  }

}
