package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public List<Student> saveAllStudent(List<Student> student) {
			return studentRepository.saveAll(student);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public List<Student> updateAllStudent(int sId, List<Student> student) {
		List<Student> oldStudent=studentRepository.findAll();
		for (Student oldOne : student) {
			for (Student newOne : oldStudent) {
				if(oldOne.getsId()==newOne.getsId()) {
					oldOne.setsName(newOne.getsName());
					oldOne.setsAge(newOne.getsAge());
					oldOne.setTotal(newOne.getsAge());
					oldOne.setAvge(newOne.getAvge());
				}
			}
		}
		return studentRepository.saveAll(student);
	}
	
//	public Student getStudent(Integer sId) {
//		return studentRepository.getById(sId);
//		
//	}

}
