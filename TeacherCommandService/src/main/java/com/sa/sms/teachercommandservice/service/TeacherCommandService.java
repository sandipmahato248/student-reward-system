package com.sa.sms.teachercommandservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sa.sms.teachercommandservice.config.FeignConfig;
import com.sa.sms.teachercommandservice.config.KafkaProducer;
import com.sa.sms.teachercommandservice.config.Message;
import com.sa.sms.teachercommandservice.dto.TeacherDto;
import com.sa.sms.teachercommandservice.dto.UserDto;

@Service
public class TeacherCommandService {
	
	@Autowired
	private TeacherFeignClient teacherFeignClient;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private KafkaProducer kafkaProducer;

	public void saveTeacher(TeacherDto teacherDto) {
	        teacherFeignClient.saveTeacher(teacherDto);
	        UserDto user = new UserDto();
	        user.setUserName(teacherDto.getTeacherId()+teacherDto.getFirstName());
	        user.setPassword("password");
	        user.setRole("TEACHER");
	        userFeignClient.saveUser(user);
	        
	        Message<?> message = new Message<>("added",user);
	        kafkaProducer.send("new-user", message);
	}
	
	  @FeignClient(name = "TEACHERSERVICE",
			  configuration = FeignConfig.class)
	    public interface TeacherFeignClient {
	        @PostMapping("/teachers")
	        TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto);
	    }
	  
	  @FeignClient(name = "USERSERVICE", configuration = FeignConfig.class)
	    public interface UserFeignClient {
	        @PostMapping("/users")
	        UserDto saveUser(@RequestBody UserDto userDto);
	    }

}
