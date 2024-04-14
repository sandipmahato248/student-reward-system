package com.swa.sms.studentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.studentservice.dto.StudentDto;
import com.swa.sms.studentservice.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
private final StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto){
		studentService.saveStudent(studentDto);
		return ResponseEntity.ok("Student Sucessfully created");	
	}
	
	@GetMapping
	public ResponseEntity<?> getAllStudents(){
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}
	
	@PutMapping("/{studentNumber}")
	public ResponseEntity<?> updateStudent(@PathVariable("studentNumber") String studentNumber, 
			@RequestBody StudentDto studentDto){
		studentService.updateStudent(studentNumber,studentDto);
		return ResponseEntity.ok("Update Sucessful");
		
	}
	
	@DeleteMapping("/{studentNumber}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentNumber") String studentNumber){
		studentService.deleteStudent(studentNumber);
		return ResponseEntity.ok("Delete sucessful");
	}

}
