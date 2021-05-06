package fr.victorianfashion.api.use_cases.User;

import fr.victorianfashion.api.domain.user;

public interface UserRepository {
    user findById(Long id);
}
