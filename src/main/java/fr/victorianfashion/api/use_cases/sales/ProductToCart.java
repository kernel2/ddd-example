package fr.victorianfashion.api.use_cases.sales;

import fr.victorianfashion.api.domain.sales.CartItem;
import fr.victorianfashion.api.domain.sales.Item;
import fr.victorianfashion.api.domain.sales.ItemAddedToCartEvent;
import fr.victorianfashion.api.domain.sales.ItemRemovedFromCartEvent;
import fr.victorianfashion.api.domain.sales.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductToCart {

  private List<DomainEvent> events = new ArrayList<>();
  private List<Item> items = new ArrayList<>();

  private Status status;

  public void addItem(Item item) {
    ItemAddedToCartEvent itemAddedEvent =
        new ItemAddedToCartEvent(
            item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity());
    apply(itemAddedEvent);
    //System.out.println("item added to chart = " + item);
  }

  public void removeItem(Item item) {

    ItemRemovedFromCartEvent itemRemovedFromCartEvent =
        new ItemRemovedFromCartEvent(item.getProduct().getName());
    apply(itemRemovedFromCartEvent);
    //System.out.println("Cart now has " + items);
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
            .get());
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
  }

  public List<Item> allItems() {
    return items;
  }
}
