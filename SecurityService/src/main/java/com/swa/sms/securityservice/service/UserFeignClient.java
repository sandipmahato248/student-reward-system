package com.swa.sms.securityservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swa.sms.securityservice.dto.UserDto;

@FeignClient("USERSERVICE")
public interface UserFeignClient {
	
	 @GetMapping("/users/{userName}")
     UserDto getUser(@PathVariable String userName);

}
