package com.sa.sms.teachercommandservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
	private String teacherId;
	private String firstName;
	private String lastName;
	private School school;
	private Contact contact;
	private TeachingClass teachingClass;

}
