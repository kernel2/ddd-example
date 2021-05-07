package fr.victorianfashion.api.use_cases.exchange;

import fr.victorianfashion.api.domain.exchange.Exchange;
import fr.victorianfashion.api.domain.exchange.Proposal;
import fr.victorianfashion.api.domain.sales.product.Product;
import fr.victorianfashion.api.use_cases.proposal.ProposalRepository;
import fr.victorianfashion.api.use_cases.user.UserRepository;

public class ApproveAnExchange {
  private final Product product;
  private final UserRepository users;
  private final ExchangeRepository exchanges;
  private final ProposalRepository proposals;

  public ApproveAnExchange(
      ExchangeRepository exchanges,
      Product product,
      ProposalRepository proposals,
      UserRepository users) {
    this.product = product;
    this.users = users;
    this.exchanges = exchanges;
    this.proposals = proposals;
  }

  public Exchange approve(Long exchangeID, Long proposalID) throws Exception {
    Exchange exchange = exchanges.findExchangeByID(exchangeID);
    Proposal proposal = proposals.findProposalById(proposalID);
    if (exchange.isOpen()) {
      throw new Exception("Exchange not available");
    }
    exchange.setApprovedProposal(proposal);
    exchanges.save(exchange);
    return exchange;
  }
}
