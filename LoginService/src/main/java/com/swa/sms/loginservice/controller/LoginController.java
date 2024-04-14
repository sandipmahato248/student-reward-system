package com.swa.sms.loginservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.loginservice.dto.LoginDto;
import com.swa.sms.loginservice.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		try { 
            return ResponseEntity.ok(loginService.getAuthToken(loginDto));
        }
        catch(Exception ex){
        	return ResponseEntity.badRequest().body("Invalid username or password");
        }
	}

}
