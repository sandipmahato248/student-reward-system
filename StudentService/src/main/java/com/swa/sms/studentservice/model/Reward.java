package com.swa.sms.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
	
	private String rewardId;
	private String name;
	private String rewardType;
	private Integer price;
	

}
