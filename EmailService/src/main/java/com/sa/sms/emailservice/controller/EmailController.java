package com.sa.sms.emailservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.sms.emailservice.dto.EmailDto;
import com.sa.sms.emailservice.service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
	
	private final EmailService emailService;
	
	@PostMapping
	public ResponseEntity<?> sendEmail(@RequestBody EmailDto emailDto){
		emailService.sendEmail(emailDto);
		return ResponseEntity.ok().body("Email sucessfully sent");
	}

}
