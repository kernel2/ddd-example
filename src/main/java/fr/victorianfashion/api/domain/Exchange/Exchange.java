package fr.victorianfashion.api.domain.Exchange;

import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.user;
import org.springframework.lang.Nullable;

import java.util.List;

public class Exchange {
    private double id;
    private user Maker;
    @Nullable
    private user Feeder;
    private List<Product> makerOffer;
    private List<Product> feederOffer;

    public Exchange(user maker, @Nullable user feeder, List<Product> makerOffer, List<Product> feederOffer) {
        Maker = maker;
        Feeder = feeder;
        this.makerOffer = makerOffer;
        this.feederOffer = feederOffer;
    }

    public List<Product> getMakerOffer() {
        return makerOffer;
    }

    public void setMakerOffer(List<Product> makerOffer) {
        this.makerOffer = makerOffer;
    }

    public List<Product> getFeederOffer() {
        return feederOffer;
    }

    public void setFeederOffer(List<Product> feederOffer) {
        this.feederOffer = feederOffer;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public user getMaker() {
        return Maker;
    }

    public void setMaker(user maker) {
        Maker = maker;
    }

    @Nullable
    public user getFeeder() {
        return Feeder;
    }

    public void setFeeder(@Nullable user feeder) {
        Feeder = feeder;
    }
}
