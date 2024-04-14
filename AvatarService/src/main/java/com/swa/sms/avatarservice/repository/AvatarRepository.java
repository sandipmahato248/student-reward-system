package com.swa.sms.avatarservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swa.sms.avatarservice.model.Avatar;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, String> {

}
