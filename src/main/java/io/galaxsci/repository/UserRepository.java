package io.galaxsci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.galaxsci.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   User findByUsername(String username);
}
