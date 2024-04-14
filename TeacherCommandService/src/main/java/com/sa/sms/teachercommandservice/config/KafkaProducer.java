package com.sa.sms.teachercommandservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class KafkaProducer {
	
	@Autowired
	KafkaTemplate kafkaTemplate;

	public void send(String topic, Message<?> message) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String messageString = objectMapper.writeValueAsString(message);
			kafkaTemplate.send(topic, messageString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
