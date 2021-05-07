package fr.victorianfashion.api.domain.recycle;

import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.domain.user.User;
import java.util.List;
import org.springframework.lang.Nullable;

public class Recycle {
  private double id;
  private User Giver;
  private List<Product> products;
  @Nullable private Double reward;

  public Recycle(User giver, List<Product> products, @Nullable Double reward) {
    Giver = giver;
    this.products = products;
    this.reward = reward;
  }

  public double getId() {
    return id;
  }

  public void setId(double id) {
    this.id = id;
  }

  public User getGiver() {
    return Giver;
  }

  public void setGiver(User giver) {
    Giver = giver;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Nullable
  public Double getReward() {
    return reward;
  }

  public void setReward(@Nullable Double reward) {
    this.reward = reward;
  }
}
