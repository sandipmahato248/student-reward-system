package com.swa.sms.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.userservice.dto.UserDto;
import com.swa.sms.userservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
		userService.saveUser(userDto);
		return ResponseEntity.ok().body("User creation sucessful");
	}
	
	@GetMapping
	public ResponseEntity<?> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
		userService.updateUser(userDto);
		return ResponseEntity.ok("Update Sucessful");
	}
	
	@DeleteMapping("/{userName}")
	public ResponseEntity<?> deleteUser(@PathVariable("userName") String userName){
		userService.deleteUser(userName);
		return ResponseEntity.ok("Delete Sucessful");
		
	}

	@GetMapping("/{userName}")
	public ResponseEntity<?> getUser(@PathVariable("userName") String userName){
		return ResponseEntity.ok(userService.getUser(userName));
		
	}
}
