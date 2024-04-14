package com.sa.sms.emailservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sa.sms.emailservice.dto.EmailDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	
	private final JavaMailSender javaMailSender;
	
	@Value("${email.from}")
	private final String FROM;

	public void sendEmail(EmailDto emailDto) {
		SimpleMailMessage sms = new SimpleMailMessage();
		sms.setFrom(FROM);
		sms.setTo(emailDto.getTo());
		sms.setSubject(emailDto.getSubject());
		sms.setText(emailDto.getBody());
		javaMailSender.send(sms);
		
		
	}

}
