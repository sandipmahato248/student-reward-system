package com.sa.sms.clientrestapplication.dto;

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
	private SchoolDto school;
	private Contact contact;
	private TeachingClass teachingClass;
}
