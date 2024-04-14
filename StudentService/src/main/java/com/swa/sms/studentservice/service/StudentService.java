package com.swa.sms.studentservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.swa.sms.studentservice.dto.StudentDto;
import com.swa.sms.studentservice.model.Student;
import com.swa.sms.studentservice.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private ModelMapper modelMapper = new ModelMapper();

	private final StudentRepository studentRepository;
	
	public void saveStudent(StudentDto studentDto) {
		Student student = new Student();
//		BeanUtils.copyProperties(studentDto, student);
//		student.setStudentClass(studentDto.getStudentClass());
//		student.setSchool(studentDto.getSchool());
		modelMapper.map(studentDto, Student.class);
		studentRepository.save(student);
	}

	public List<StudentDto> getAllStudents() {
		return studentRepository.findAll().stream()
				.map(student -> modelMapper.map(student, StudentDto.class))
				.collect(Collectors.toList());
	}

	public void updateStudent(String studentNumber, StudentDto studentDto) {
		Student oStudent = studentRepository.findById(studentNumber).get();
		oStudent.setFirstName(studentDto.getFirstName());
		oStudent.setLastName(studentDto.getLastName());
		oStudent.setAvatar(studentDto.getAvatar());
		oStudent.setRewardList(studentDto.getRewardList());
		oStudent.setScore(studentDto.getScore());
		oStudent.setStudentClass(studentDto.getStudentClass());
		oStudent.setSchool(studentDto.getSchool());
		studentRepository.save(oStudent);
		
		
		
	}

	public void deleteStudent(String studentNumber) {
		studentRepository.deleteById(studentNumber);
	}

}
