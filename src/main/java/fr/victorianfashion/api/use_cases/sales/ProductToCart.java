package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.DomainEvent;
import fr.victorianfashion.api.domain.sales.ItemAddedToCartEvent;
import fr.victorianfashion.api.domain.sales.ItemRemovedFromCartEvent;
import fr.victorianfashion.api.domain.sales.cart.CartCheckedOut;
import fr.victorianfashion.api.domain.sales.cart.CartItem;
import fr.victorianfashion.api.domain.sales.cart.Item;
import fr.victorianfashion.api.domain.sales.product.Price;
import fr.victorianfashion.api.domain.sales.product.Product;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

enum Status {
  CHECKEDOUT,
  AVAILABLE
}

public class ProductToCart {

  private final List<DomainEvent> events = new ArrayList<>();
  private final List<Item> items = new ArrayList<>();
  private Instant lastModifiedTime;
  private int cartMaxItemsLimit = 10;

  private Status status;

  public void addItem(Item item) {
    if (validateMaxItemsLimit(1) && isQtyWithinAllowedLimit(item)) {
      this.items.add(item);
      calculateCartPrice();
      updateLastModifiedTime();

      ItemAddedToCartEvent itemAddedEvent =
          new ItemAddedToCartEvent(
              item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity());
      apply(itemAddedEvent);
    } else {
      new RessourceNotFoundException("Panier dépasser le quota");
    }
  }

  public String removeItem(Item item) {

    ItemRemovedFromCartEvent itemRemovedFromCartEvent =
        new ItemRemovedFromCartEvent(item.getProduct().getName());
    apply(itemRemovedFromCartEvent);
    return "item has been removed";
  }

  private void apply(ItemAddedToCartEvent event) {
    events.add(event);
    this.items.add(
        new Item(new Product(event.getName(), event.getPrice(), 1.0), event.getQuantity()));
  }

  private void apply(ItemRemovedFromCartEvent event) {
    events.add(event);
    this.items.remove(
        this.items.stream()
            .filter(item -> item.getProduct().getName().equals(event.getName()))
            .findFirst()
            .orElse(null));
  }

  public void checkOut() {
    this.status = Status.CHECKEDOUT;

    List<CartItem> cartItems =
        items.stream()
            .map(
                item ->
                    new CartItem(
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()))
            .collect(Collectors.toList());

    events.add(new CartCheckedOut(cartItems));
    // System.out.println("checkOut of cartItems is ==> "+cartItems);
  }

  public List<Item> allItems() {
    return items;
  }

  public boolean isBasketEmpty() {
    return items.size() <= 0;
  }

  public int getTotalItemsInCart() {
    return items.size();
  }

  private boolean validateMaxItemsLimit(int itemCountToAdd) {
    // Vérification que les invariants sont satisfaits. Le panier ne peut pas avoir plus de 10 ietms, le panier ne peut pas avoir 2qty par
    // item.
    return getTotalItemsInCart() + itemCountToAdd <= cartMaxItemsLimit ? false : true;
  }

  private boolean isQtyWithinAllowedLimit(Item cartItem) {
    return cartItem.isQtyWithinAllowedLimit();
  }

  private Price calculateCartPrice() {
    return items.stream()
        .map(product -> product.getProduct().getPrice())
        .reduce(new Price(BigDecimal.ZERO, Currency.getInstance("EURO")), (price1, price2) -> price1.add(price2));
  }

  private void updateLastModifiedTime() {
    this.lastModifiedTime = Instant.now();
  }
}
