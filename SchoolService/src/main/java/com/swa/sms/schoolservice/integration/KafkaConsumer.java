package com.swa.sms.schoolservice.integration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swa.sms.schoolservice.model.School;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = {"new-school"})
	 public void listenWhenSchoolAdded(@Payload String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("Received new school details ....");
            School messageDetails = objectMapper
            		.readValue(message, new TypeReference<Message<School>>() {
            }).getMessage();
            System.out.println("inn listner>>"+messageDetails.getName());
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
