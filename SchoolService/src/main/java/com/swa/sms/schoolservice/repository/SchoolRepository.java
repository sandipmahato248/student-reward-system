package com.swa.sms.schoolservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swa.sms.schoolservice.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

}
