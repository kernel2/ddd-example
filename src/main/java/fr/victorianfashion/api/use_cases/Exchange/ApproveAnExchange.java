package fr.victorianfashion.api.use_cases.Exchange;

import fr.victorianfashion.api.domain.Exchange.Exchange;
import fr.victorianfashion.api.domain.Exchange.Proposal;
import fr.victorianfashion.api.use_cases.Proposal.ProposalRepository;
import fr.victorianfashion.api.use_cases.User.UserRepository;
import fr.victorianfashion.api.use_cases.product.Products;

public class ApproveAnExchange {
    private final Products products;
    private final UserRepository users;
    private final ExchangeRepository exchanges;
    private final ProposalRepository proposals;

    public ApproveAnExchange(ExchangeRepository exchanges,Products products,
                             ProposalRepository proposals, UserRepository users) {
        this.products = products;
        this.users = users;
        this.exchanges = exchanges;
        this.proposals = proposals;
    }

    public Exchange approve(Long exchangeID, Long proposalID) throws Exception {
        Exchange exchange = exchanges.findExchangeByID(exchangeID);
        Proposal proposal = proposals.findProposalById(proposalID);
        if(exchange.isOpen()){
            throw new Exception("Exchange not available");
        }
        exchange.setApprovedProposal(proposal);
        exchanges.save(exchange);
        return exchange;
    }


}
