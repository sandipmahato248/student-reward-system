package com.swa.sms.schoolservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.schoolservice.dto.SchoolDto;
import com.swa.sms.schoolservice.service.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

	private final SchoolService schoolService;

	@PostMapping
	ResponseEntity<?> saveSchool(@RequestBody SchoolDto schoolDto) {
		schoolService.saveSchool(schoolDto);
		return ResponseEntity.ok("School sucessfully created");
	}

	@GetMapping
	ResponseEntity<?> getAllSchools() {
		return ResponseEntity.ok(schoolService.getAllSchools());
	}

	@PutMapping("/{schoolId}")
	ResponseEntity<?> updateSchool(@PathVariable("schoolId") String schoolId, @RequestBody SchoolDto schoolDto) {
		schoolService.updateSchool(schoolId,schoolDto);
		return ResponseEntity.ok("Update Sucessful");

	}

	@DeleteMapping("/{schoolId}")
	ResponseEntity<?> deleteSchool(@PathVariable("schoolId") String schoolId) {
		schoolService.deleteSchool(schoolId);
		return ResponseEntity.ok("Delete Sucessful");
	}

}
