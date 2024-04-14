package com.swa.sms.schoolservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swa.sms.schoolservice.dto.SchoolDto;
import com.swa.sms.schoolservice.integration.KafkaProducer;
import com.swa.sms.schoolservice.integration.Message;
import com.swa.sms.schoolservice.model.School;
import com.swa.sms.schoolservice.repository.SchoolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final SchoolRepository schoolRepository;
	
	@Autowired
	private KafkaProducer kafkaProducer;

	public void saveSchool(SchoolDto schoolDto) {
		School school = new School();
		modelMapper.map(schoolDto, school);
		//BeanUtils.copyProperties(schoolDto, school);
		//school.setContact(schoolDto.getContact());
		schoolRepository.save(school);
		Message<School> message = new Message<>("added",school);
		kafkaProducer.send("new-school", message);
	}

	public List<SchoolDto> getAllSchools() {
		return schoolRepository.findAll()
				.stream().map(school -> modelMapper.map(school, SchoolDto.class))
				.collect(Collectors.toList());
	
	}
	

	public void updateSchool(String schoolId, SchoolDto schoolDto) {
		School oSchool = schoolRepository.findById(schoolId).get();
		oSchool.setName(schoolDto.getName());
		oSchool.setAddress(schoolDto.getAddress());
		oSchool.setContact(schoolDto.getContact());
		schoolRepository.save(oSchool);
	}

	public void deleteSchool(String schoolId) {
		schoolRepository.deleteById(schoolId);
	}

}
