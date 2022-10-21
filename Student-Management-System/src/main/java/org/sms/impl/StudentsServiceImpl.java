package org.sms.impl;

import java.util.List;

import org.sms.entity.Students;
import org.sms.repository.StudentsRepository;
import org.sms.service.StudentsService;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements StudentsService{

	private StudentsRepository studentsRepository;
	
	
	public StudentsServiceImpl(StudentsRepository studentsRepository) {
		super();
		this.studentsRepository = studentsRepository;
	}


	@Override
	public List<Students> getAllStudents() {
		return studentsRepository.findAll();
	}


	@Override
	public Students saveStudents(Students students) {
		return studentsRepository.save(students);
	}


	@Override
	public Students getStudentById(Long id) {
		return studentsRepository.findById(id).get();
	}


	@Override
	public Students updateStudent(Students students) {
		return studentsRepository.save(students);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentsRepository.deleteById(id);
	}

}
