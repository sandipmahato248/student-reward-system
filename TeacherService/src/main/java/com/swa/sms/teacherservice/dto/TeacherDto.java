package com.swa.sms.teacherservice.dto;

import com.swa.sms.teacherservice.model.Contact;
import com.swa.sms.teacherservice.model.School;
import com.swa.sms.teacherservice.model.TeachingClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
	private String teacherId;
	private String firstName;
	private String lastName;
	private School school;
	private Contact contact;
	private TeachingClass teachingClass;

}
