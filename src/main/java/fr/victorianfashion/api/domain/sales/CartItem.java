package fr.victorianfashion.api.domain.sales;

public class CartItem {
  String name;
  Price price;
  int quantity;

  public CartItem(String name, Price price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public Price getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }
}
