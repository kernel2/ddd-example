package fr.victorianfashion.api.domain.Recycle;

import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.user;
import org.springframework.lang.Nullable;

import java.util.List;

public class Recycling {
    private Long id;
    private user Giver;
    private List<Product> products;
    private String state; // valid values : "created", "shipped", "received", "closed"
    @Nullable
    private Double reward;
    private String deliveryReference;


    public Recycling(user giver, List<Product> products, @Nullable Double reward) {
        Giver = giver;
        this.products = products;
        this.reward = reward;
    }

    public Recycling(){}

    public void addProduct(Product product){
        this.products.add(product);
    }

    public double getId() {
        return id;
    }

    public void setId(Long id) {
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
