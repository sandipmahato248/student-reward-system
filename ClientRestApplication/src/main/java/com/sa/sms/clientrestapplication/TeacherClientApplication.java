package com.sa.sms.clientrestapplication;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sa.sms.clientrestapplication.dto.Contact;
import com.sa.sms.clientrestapplication.dto.LoginDto;
import com.sa.sms.clientrestapplication.dto.SchoolDto;
import com.sa.sms.clientrestapplication.dto.TeacherDto;
import com.sa.sms.clientrestapplication.dto.TeachingClass;

@SpringBootApplication
public class TeacherClientApplication implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;

	private final static String URL = "http://localhost:9191";

	private String login(String userName, String password) throws Exception {
		try {
			return restTemplate.postForObject(URL + "/login", new LoginDto(userName, password), String.class);
		} catch (Exception e) {
			throw new Exception("Invalid username or password");
		}
	}

	private <T> void customPostRequest(String path, T requestBody, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<T> request = new HttpEntity<>(requestBody, headers);
		restTemplate.postForLocation(URL + path, request);
		System.out.println("Added Successfully");
	}

	private void addTeacher(String token) {
		TeacherDto teacherDto = new TeacherDto("teacher1","Ali", "Bouzer",
				new SchoolDto("MIU", "Maharishi International University", "Fairfield",
						new Contact("miu@miu.com", "6412339191")),
			    new Contact("teacher1@miu.edu","6412339090"),
			    new TeachingClass("2021","4"));
				
		customPostRequest("/teachers", teacherDto, token);
		System.out.println("Teacher sucessfully added by admin");
	}

	private List<TeacherDto> getAllTeachers(String token) {
		String authorization = "Bearer " + token;
		System.out.println(token);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<List<TeacherDto>> response = restTemplate.exchange(URL +"/teachers",
				HttpMethod.GET, request,new ParameterizedTypeReference<>() {
				});
		if(Objects.nonNull(response))
			response.getBody().forEach(System.out::println);
		return response.getBody();
	}

	public <T> void customPutRequest(String path, T requestBody, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<T> request = new HttpEntity<>(requestBody, headers);
		restTemplate.put(URL + path, request);
		System.out.println("Update Successful...");
	}
	
	private void updateTeacher(String token) {
		List<TeacherDto> teacherList = getAllTeachers(token);
		TeacherDto teacher = teacherList.get(0);
		teacher.setFirstName("Updated Teacher");
		customPutRequest("/teachers/"+teacher.getTeacherId(), teacher, token);
		System.out.println("update sucessful...");
	}
	
	public <T> void customDeleteRequest(String path, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
	                URL + path,
	                HttpMethod.DELETE,
	                request,
	                new ParameterizedTypeReference<>() {
	                }
	        );
		System.out.println("Delete Successful...");
	}

	
	private void deleteTeacher(String token) {
		List<TeacherDto> teacherList = getAllTeachers(token);
		TeacherDto teacher = teacherList.get(0);
		customDeleteRequest("/teachers/"+teacher.getTeacherId(), token);
		System.out.println("delete sucessful...");
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------------------------");
		System.out.println("Login as Admin");
		String token = login("admin", "password");
		if (Objects.nonNull(token))
			System.out.println("Login Sucess as Admin");
		System.out.println("------------------------------------");

		System.out.println("Adding Teacher as Admin");
		addTeacher(token);
		System.out.println("------------------------------------");

		System.out.println("Get All Teachers");
		getAllTeachers(token);
		System.out.println("------------------------------------");
		
		System.out.println("Update teacher details");
		updateTeacher(token);
		System.out.println("------------------------------------");
		
		System.out.println("Delete teacher details");
		deleteTeacher(token);
		System.out.println("------------------------------------");
	}

}
