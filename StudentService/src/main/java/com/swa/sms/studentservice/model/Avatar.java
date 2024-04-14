package com.swa.sms.studentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Avatar {
	@Id
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
