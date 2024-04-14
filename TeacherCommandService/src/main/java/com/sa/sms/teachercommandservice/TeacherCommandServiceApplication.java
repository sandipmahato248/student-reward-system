package com.sa.sms.teachercommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
@EnableKafka
@EnableFeignClients
public class TeacherCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherCommandServiceApplication.class, args);
	}

}
