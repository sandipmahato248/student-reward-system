package com.swa.sms.teacherservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swa.sms.teacherservice.model.Teacher;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String>{

}
