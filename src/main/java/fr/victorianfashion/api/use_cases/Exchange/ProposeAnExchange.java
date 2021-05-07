//package fr.victorianfashion.api.use_cases.Exchange;
//
//import fr.victorianfashion.api.domain.Exchange.Exchange;
//import fr.victorianfashion.api.domain.Exchange.Proposal;
//import fr.victorianfashion.api.domain.product.Product;
//import fr.victorianfashion.api.use_cases.Proposal.ProposalRepository;
//import fr.victorianfashion.api.use_cases.User.UserRepository;
//
//public class ProposeAnExchange {
//  public final ProposalRepository proposals;
//  private final Product product;
//  private final UserRepository users;
//  private final ExchangeRepository exchanges;
//
//  public ProposeAnExchange(
//      ProposalRepository proposals,
//      Product product,
//      UserRepository users,
//      ExchangeRepository exchanges) {
//    this.product = product;
//    this.users = users;
//    this.exchanges = exchanges;
//    this.proposals = proposals;
//  }
//
//  public Exchange ProposeExchange(Long exchangeID, Long proposalID) throws Exception {
//    Exchange exchange = exchanges.findExchangeByID(exchangeID);
//    Proposal proposal = proposals.findProposalById(proposalID);
//    if (!exchange.isOpen()) {
//      throw new Exception("Exchange not available");
//    }
//    exchange.addProposal(proposal);
//    exchanges.save(exchange);
//    return exchange;
//  }
//}
