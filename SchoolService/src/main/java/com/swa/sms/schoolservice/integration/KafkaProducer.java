package com.swa.sms.schoolservice.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
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
