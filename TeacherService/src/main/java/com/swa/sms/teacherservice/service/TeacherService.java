package com.swa.sms.teacherservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swa.sms.teacherservice.dto.TeacherDto;
import com.swa.sms.teacherservice.model.Teacher;
import com.swa.sms.teacherservice.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public void saveTeacher(TeacherDto teacherDto) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacherDto, teacher);
		teacher.setContact(teacherDto.getContact());
		teacher.setTeachingClass(teacherDto.getTeachingClass());
		teacher.setSchool(teacherDto.getSchool());
		System.out.println(teacher);
		teacherRepository.save(teacher);
	}

	public List<TeacherDto> getAllTeachers() {
		List<TeacherDto> list = teacherRepository.findAll().stream()
				.map(teacher -> modelMapper.map(teacher,TeacherDto.class))
				.collect(Collectors.toList());
		list.forEach(System.out::println);
		return list;
	}

	public void updateTeacher(String teacherId, TeacherDto teacherDto) {
		Teacher oTeacher = teacherRepository.findById(teacherId).get();
		oTeacher.setFirstName(teacherDto.getFirstName());
		oTeacher.setLastName(teacherDto.getLastName());
		oTeacher.setContact(teacherDto.getContact());
		oTeacher.setSchool(teacherDto.getSchool());
		oTeacher.setTeachingClass(teacherDto.getTeachingClass());
		teacherRepository.save(oTeacher);
	}

	public void deleteTeacher(String teacherId) {
		teacherRepository.deleteById(teacherId);
	}

}
