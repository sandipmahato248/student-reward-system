package com.swa.sms.securityservice.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.swa.sms.securityservice.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@EnableFeignClients
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{
	
	private final UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username "+username);
		UserDto userDto = userFeignClient.getUser(username);
		
		if (userDto == null) 
            throw new UsernameNotFoundException(username);
        
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userDto.getRole().toUpperCase()));
        return new User(userDto.getUserName(), userDto.getPassword(), authorities);
	}

}
