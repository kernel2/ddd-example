package fr.victorianfashion.api.domain.Exchange;

import fr.victorianfashion.api.domain.product.Product;
import fr.victorianfashion.api.domain.user;
import java.util.List;
import org.springframework.lang.Nullable;

public class Exchange {
  private double id;
  private user Maker;
  @Nullable private List<Proposal> proposals;
  @Nullable private Proposal approvedProposal;
  private Product makerOffer;
  private String state; // valid values : "open", "reserved", "shipped", "closed"

  public Exchange(user maker, Product makerOffer, String state) {
    Maker = maker;
    this.makerOffer = makerOffer;
    this.state = state;
  }

  public Exchange() {}

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public boolean isOpen() {
    return this.state == "open";
  }

  public void addProposal(Proposal proposal) {
    this.proposals.add(proposal);
  }

  public Product getMakerOffer() {
    return makerOffer;
  }

  public void setMakerOffer(Product makerOffer) {
    this.makerOffer = makerOffer;
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

  public void setApprovedProposal(Proposal proposal) {
    this.approvedProposal = approvedProposal;
  }
}
