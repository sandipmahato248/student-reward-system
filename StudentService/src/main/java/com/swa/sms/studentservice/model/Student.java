package com.swa.sms.studentservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Student {
	
	@Id
	private String studentNumber;
	private String  firstName;
	private String lastName;
	private School school;
	private StudentClass studentClass;
	private Integer score = 1000;
	private Avatar avatar;
	private List<Reward> rewardList;

}
