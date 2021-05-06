package fr.victorianfashion.api.use_cases.Exchange;

import fr.victorianfashion.api.domain.Exchange.Exchange;
import fr.victorianfashion.api.domain.Exchange.Proposal;
import fr.victorianfashion.api.use_cases.Proposal.ProposalRepository;
import fr.victorianfashion.api.use_cases.User.UserRepository;
import fr.victorianfashion.api.use_cases.product.Products;

public class ProposeAnExchange {
    private final Products products;
    private final UserRepository users;
    private final ExchangeRepository exchanges;
    public final ProposalRepository proposals;

    public ProposeAnExchange(ProposalRepository proposals ,Products products, UserRepository users, ExchangeRepository exchanges) {
        this.products = products;
        this.users = users;
        this.exchanges = exchanges;
        this.proposals = proposals;
    }

    public Exchange ProposeExchange(Long exchangeID, Long proposalID) throws Exception {
        Exchange exchange = exchanges.findExchangeByID(exchangeID);
        Proposal proposal = proposals.findProposalById(proposalID);
        if(!exchange.isOpen()){
            throw new Exception("Exchange not available");
        }
        exchange.addProposal(proposal);
        exchanges.save(exchange);
        return exchange;
    }

}
