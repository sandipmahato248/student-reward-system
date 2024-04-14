package com.sa.sms.clientrestapplication;

import java.util.ArrayList;
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

import com.sa.sms.clientrestapplication.dto.Avatar;
import com.sa.sms.clientrestapplication.dto.Contact;
import com.sa.sms.clientrestapplication.dto.LoginDto;
import com.sa.sms.clientrestapplication.dto.Reward;
import com.sa.sms.clientrestapplication.dto.SchoolDto;
import com.sa.sms.clientrestapplication.dto.StudentClass;
import com.sa.sms.clientrestapplication.dto.StudentDto;

@SpringBootApplication
public class StudentClientApplication implements CommandLineRunner {
	
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

	private void addStudent(String token) {
		List<Reward> rewardList = new ArrayList<>();
		Reward reward = new Reward("1","Reward 1","Gift",100);
		rewardList.add(reward);
		StudentDto studentDto = new StudentDto(
				"101","Sandip","Mahato",
				new SchoolDto("MIU", "Maharishi International University", "Fairfield",
						new Contact("miu@miu.com", "6412339191")),
				new StudentClass("2022", "2"),
				1000,
				new Avatar("1","Round","black","blue","eyebrow","long",
						"mouth","ears","body","hat","top","red","black"),
				rewardList);
		
	
		
				
		customPostRequest("/students", studentDto, token);
		System.out.println("Student sucessfully added by teacher");
	}

	private List<StudentDto> getAllStudents(String token) {
		String authorization = "Bearer " + token;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);
		HttpEntity<Object> request = new HttpEntity<>(headers);
		ResponseEntity<List<StudentDto>> response = restTemplate.exchange(URL +"/students",
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
	
	private void updateStudent(String token) {
		List<StudentDto> studentList = getAllStudents(token);
		StudentDto student = studentList.get(0);
		//student.setFirstName("Updated Teacher");
		customPutRequest("/students/"+student.getStudentNumber(), student, token);
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

	
	private void deleteStudent(String token) {
		List<StudentDto> studentList = getAllStudents(token);
		StudentDto student = studentList.get(0);
		customDeleteRequest("/students/"+student.getStudentNumber(), token);
		System.out.println("delete sucessful...");
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------------------------");
		System.out.println("Login as Teacher");
		String token = login("teacher", "password");
		if (Objects.nonNull(token))
			System.out.println("Login Sucess as teacher");
		System.out.println("------------------------------------");

		System.out.println("Adding Student by teacher");
		addStudent(token);
		System.out.println("------------------------------------");

		System.out.println("Get All Students");
		getAllStudents(token);
		System.out.println("------------------------------------");
		
		System.out.println("Update student details");
		updateStudent(token);
		System.out.println("------------------------------------");
		
		System.out.println("Delete student details");
		deleteStudent(token);
		System.out.println("------------------------------------");
	}


}
