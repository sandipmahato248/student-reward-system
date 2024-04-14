package com.sa.sms.teachercommandservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.sms.teachercommandservice.dto.TeacherDto;
import com.sa.sms.teachercommandservice.service.TeacherCommandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teacher/command")
@RequiredArgsConstructor
public class TeacherCommandController {

	private final TeacherCommandService teacherAdminService;

	@PostMapping
	public ResponseEntity<?> saveTeacher(@RequestBody TeacherDto teacherDto) {
		teacherAdminService.saveTeacher(teacherDto);
		return ResponseEntity.ok().body("Sucessfully saved");

	}

}
