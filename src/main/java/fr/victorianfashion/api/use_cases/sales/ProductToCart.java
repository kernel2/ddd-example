package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.cart.CartCheckedOut;
import fr.victorianfashion.api.domain.sales.cart.CartItem;
import fr.victorianfashion.api.domain.sales.DomainEvent;
import fr.victorianfashion.api.domain.sales.product.Item;
import fr.victorianfashion.api.domain.sales.ItemAddedToCartEvent;
import fr.victorianfashion.api.domain.sales.ItemRemovedFromCartEvent;
import fr.victorianfashion.api.domain.sales.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductToCart {

  private final List<DomainEvent> events = new ArrayList<>();
  private final List<Item> items = new ArrayList<>();

  private Status status;

  public Item addItem(Item item) {
    ItemAddedToCartEvent itemAddedEvent =
        new ItemAddedToCartEvent(
            item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity());
    apply(itemAddedEvent);
    return item;
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
    //System.out.println("checkOut of cartItems is ==> "+cartItems);
  }

  public List<Item> allItems() {
    return items;
  }
}

enum Status {
  CHECKEDOUT,
  AVAILABLE
}