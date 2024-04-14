package com.sa.sms.teachercommandservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

@Configuration
public class FeignConfig {
	@Bean
	public AuthRequestInterceptor authRequestInterceptor(OAuth2ClientContext oAuth2ClientContext,
			OAuth2RestTemplate oAuth2RestTemplate) {
		return new AuthRequestInterceptor(oAuth2ClientContext, oAuth2RestTemplate);
	}

}
