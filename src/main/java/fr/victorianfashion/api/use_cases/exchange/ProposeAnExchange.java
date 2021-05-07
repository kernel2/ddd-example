package fr.victorianfashion.api.use_cases.exchange;

import fr.victorianfashion.api.domain.exchange.Exchange;
import fr.victorianfashion.api.domain.exchange.Proposal;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.use_cases.proposal.ProposalRepository;
import fr.victorianfashion.api.use_cases.user.UserRepository;

public class ProposeAnExchange {
  public final ProposalRepository proposals;
  private final Product product;
  private final UserRepository users;
  private final ExchangeRepository exchanges;

  public ProposeAnExchange(
      ProposalRepository proposals,
      Product product,
      UserRepository users,
      ExchangeRepository exchanges) {
    this.product = product;
    this.users = users;
    this.exchanges = exchanges;
    this.proposals = proposals;
  }

  public Exchange ProposeExchange(Long exchangeID, Long proposalID) throws Exception {
    Exchange exchange = exchanges.findExchangeByID(exchangeID);
    Proposal proposal = proposals.findProposalById(proposalID);
    if (!exchange.isOpen()) {
      throw new Exception("Exchange not available");
    }
    exchange.addProposal(proposal);
    exchanges.save(exchange);
    return exchange;
  }
}
