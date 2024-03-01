package com.chat.backend.loginservice;

import com.chat.backend.loginservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    List<User> findAllByStatus();
}
