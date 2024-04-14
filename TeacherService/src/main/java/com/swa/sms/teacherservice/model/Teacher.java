package com.swa.sms.teacherservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Teacher {
	@Id
	private String teacherId;
	private String firstName;
	private String lastName;
	private Contact contact;
	private School school;
	private TeachingClass teachingClass;

}
