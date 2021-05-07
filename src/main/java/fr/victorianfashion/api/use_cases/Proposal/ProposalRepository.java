package fr.victorianfashion.api.use_cases.Proposal;

import fr.victorianfashion.api.domain.Exchange.Proposal;

public interface ProposalRepository {
  Proposal findProposalById(Long proposalId);
}
