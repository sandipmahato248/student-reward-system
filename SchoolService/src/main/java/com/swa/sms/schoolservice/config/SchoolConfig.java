package com.swa.sms.schoolservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SchoolConfig {
	
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
