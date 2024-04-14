package com.swa.sms.avatarservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarDto {
	private String avatarId;
	private String head;
	private String hair;
	private String eye;
	private String eyebrow;
	private String nose;
	private String mouth;
	private String ears;
	private String body;
	private String hat;
	private String top;
	private String topColour;
	private String hatColour;
}
