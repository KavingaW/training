package com.hsenid.springsecurity.repository;

import com.hsenid.springsecurity.model.RoleEnum;
import com.hsenid.springsecurity.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}