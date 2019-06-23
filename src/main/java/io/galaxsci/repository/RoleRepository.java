package io.galaxsci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.galaxsci.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
