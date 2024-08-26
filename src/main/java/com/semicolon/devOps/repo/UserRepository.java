package com.semicolon.devOps.repo;

import com.semicolon.devOps.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);
}
