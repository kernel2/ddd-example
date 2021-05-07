package fr.victorianfashion.api.use_cases.proposal;

import fr.victorianfashion.api.domain.exchange.Proposal;

public interface ProposalRepository {
  Proposal findProposalById(Long proposalId);
}
