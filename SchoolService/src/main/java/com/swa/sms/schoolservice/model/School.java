package com.swa.sms.schoolservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class School {
	@Id
	private String schoolId;
	private String name;
	private String address;
	private Contact contact;

}
