package com.example.sajayanegar.repository;

import com.example.sajayanegar.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
