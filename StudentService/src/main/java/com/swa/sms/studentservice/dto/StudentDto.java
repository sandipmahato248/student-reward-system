package com.swa.sms.studentservice.dto;

import java.util.List;

import com.swa.sms.studentservice.model.Avatar;
import com.swa.sms.studentservice.model.Reward;
import com.swa.sms.studentservice.model.School;
import com.swa.sms.studentservice.model.StudentClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private String studentNumber;
	private String  firstName;
	private String lastName;
	private School school;
	private StudentClass studentClass;
	private Integer score;
	private Avatar avatar;
	private List<Reward> rewardList;

}
