package com.sa.sms.clientrestapplication.dto;

import java.util.List;

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
	private SchoolDto school;
	private StudentClass studentClass;
	private Integer score;
	private Avatar avatar;
	private List<Reward> rewardList;
}
