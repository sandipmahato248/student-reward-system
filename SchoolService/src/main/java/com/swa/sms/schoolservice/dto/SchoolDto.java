package com.swa.sms.schoolservice.dto;

import com.swa.sms.schoolservice.model.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
	private String schoolId;
	private String name;
	private String address;
	private Contact contact;

	
	

}
