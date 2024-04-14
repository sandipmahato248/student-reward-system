package com.sa.sms.clientrestapplication.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sa.sms.clientrestapplication.dto.LoginDto;


public class RestUtility {
	
	@Autowired
	private static RestTemplate restTemplate;
	
	private final String URL = "http://localhost:9191/login";
	
//	public  String login(String userName, String password) throws Exception {
//		System.out.println(URL + userName+password);
//		try {
//			
//			return restTemplate.postForObject(URL, new LoginDto(userName, password), String.class);
//		} catch (Exception e) {
//			throw new Exception("Invalid username or password");
//		}
//	}
	
//	public static <T> void customPostRequest(String path, T requestBody, String token) {
//		String authorization = "Bearer " + token;
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.set("Authorization", authorization);
//
//		HttpEntity<T> request = new HttpEntity<>(requestBody, headers);
//		restTemplate.postForLocation(URL + path, request);
//		System.out.println("Added Successfully");
//	}
//	
//    public <T> void customPutRequest(String path, T requestBody, String token) {
//        String authorization = "Bearer " + token;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", authorization);
//
//        HttpEntity<T> request = new HttpEntity<>(requestBody, headers);
//        restTemplate.put(URL + path, request);
//        System.out.println("Success...");
//    }
//
//    public <T> void sentDeleteRequest(String path, String token) {
//        String authorization = "Bearer " + token;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", authorization);
//
//        HttpEntity<T> request = new HttpEntity<>(headers);
//
//        restTemplate.delete(URL + path, request);
//        System.out.println("Success...");
//    }

}
