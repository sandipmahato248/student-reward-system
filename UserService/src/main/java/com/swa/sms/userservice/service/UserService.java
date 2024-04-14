package com.swa.sms.userservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swa.sms.userservice.dto.UserDto;
import com.swa.sms.userservice.model.User;
import com.swa.sms.userservice.repository.UserRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	//private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserRepository userRepository;
	
	public void saveUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public void updateUser(UserDto userDto) {
		User oUser = userRepository.findById(userDto.getUserName()).get();
		oUser.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		oUser.setRole(userDto.getRole());
		userRepository.save(oUser);
	}

	public void deleteUser(String userName) {
		userRepository.deleteById(userName);
	}

	public UserDto getUser(String userName) {
		User user = userRepository.findById(userName).get();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

}
