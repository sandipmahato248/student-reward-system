package com.sa.sms.teachercommandservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

//@Configuration
//@RequiredArgsConstructor
public class AuthRequestInterceptor implements RequestInterceptor {

	private final OAuth2ClientContext oAuth2ClientContext;
    private final OAuth2RestTemplate oAuth2RestTemplate;
    
    public AuthRequestInterceptor(OAuth2ClientContext oAuth2ClientContext,
    		OAuth2RestTemplate oAuth2RestTemplate) {
        this.oAuth2ClientContext = oAuth2ClientContext;
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }
    
 
    
	@Override
	public void apply(RequestTemplate template) {
		OAuth2AccessToken accessToken = oAuth2ClientContext.getAccessToken();
		System.out.println("====>>>"+oAuth2ClientContext.toString());
		if (accessToken == null) {
			accessToken = oAuth2RestTemplate.getAccessToken();
		}
		template.header("Authorization", "Bearer "+ "EYSMRaLMTWe7vuxpNe8vYnNCVQE" );
		//template.header("Authorization", "Bearer " + accessToken.getValue());
	}

}
