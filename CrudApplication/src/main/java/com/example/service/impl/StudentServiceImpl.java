package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
