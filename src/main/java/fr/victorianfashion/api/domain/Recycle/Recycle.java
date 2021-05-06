package fr.victorianfashion.api.domain.Recycle;

import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.user;
import org.springframework.lang.Nullable;

import java.util.List;

public class Recycle {
    private double id;
    private user Giver;
    private List<Product> products;
    @Nullable
    private Double reward;

    public Recycle(user giver, List<Product> products, @Nullable Double reward) {
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

    public user getGiver() {
        return Giver;
    }

    public void setGiver(user giver) {
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
