package com.swa.sms.avatarservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.sms.avatarservice.dto.AvatarDto;
import com.swa.sms.avatarservice.service.AvatarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avatars")
@RequiredArgsConstructor
public class AvatarController {
	
	private final AvatarService avatarService;
	
	@PostMapping
	public ResponseEntity<?> saveAvatar(@RequestBody AvatarDto avatarDto){
		avatarService.saveAvatar(avatarDto);
		return ResponseEntity.ok("Avatar Sucessfully saved");	
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAvatars(){
		return ResponseEntity.ok().body(avatarService.getAllAvatars());
	}
	
	@PutMapping("/{avatarId}")
	public ResponseEntity<?> updateAvatar(@PathVariable("avatarId") String avatarId, 
			@RequestBody AvatarDto avatarDto){
		avatarService.updateAvatar(avatarId,avatarDto);
		return ResponseEntity.ok("Update Sucessful");
		
	}
	
	@DeleteMapping("/{avatarId}")
	public ResponseEntity<?> deleteAvatar(@PathVariable("avatarId") String avatarId){
		avatarService.deleteAvatar(avatarId);
		return ResponseEntity.ok("Delete sucessful");
	}

}
