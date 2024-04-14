package com.sa.sms.clientrestapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reward {
	private String rewardId;
	private String name;
	private String rewardType;
	private Integer price;

}
