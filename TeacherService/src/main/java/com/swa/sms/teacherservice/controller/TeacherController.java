package com.swa.sms.teacherservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.teacherservice.dto.TeacherDto;
import com.swa.sms.teacherservice.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
	
	private final TeacherService teacherService;
	
	@PostMapping
	public ResponseEntity<?> saveTeacher(@RequestBody TeacherDto teacherDto){
		teacherService.saveTeacher(teacherDto);
		return ResponseEntity.ok("Teacher Sucessfully created");	
	}
	
	@GetMapping
	public ResponseEntity<?> getAllTeachers(){
		return ResponseEntity.ok().body(teacherService.getAllTeachers());
	}
	
	@PutMapping("/{teacherId}")
	public ResponseEntity<?> updateTeacher(@PathVariable("teacherId") String teacherId, 
			@RequestBody TeacherDto teacherDto){
		teacherService.updateTeacher(teacherId,teacherDto);
		return ResponseEntity.ok("Update Sucessful");
		
	}
	
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<?> deleteTeacher(@PathVariable("teacherId") String teacherId){
		teacherService.deleteTeacher(teacherId);
		return ResponseEntity.ok("Delete sucessful");
	}

}
