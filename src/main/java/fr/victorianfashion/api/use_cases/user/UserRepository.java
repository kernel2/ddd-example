package fr.victorianfashion.api.use_cases.user;

import fr.victorianfashion.api.domain.user.User;

public interface UserRepository {
  User findById(Long id);
}