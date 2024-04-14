package com.swa.sms.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swa.sms.userservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
