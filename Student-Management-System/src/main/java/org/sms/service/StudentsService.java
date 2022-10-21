package org.sms.service;

import java.util.List;

import org.sms.entity.Students;
import org.springframework.stereotype.Service;

public interface StudentsService {
	List<Students> getAllStudents();
	Students saveStudents(Students students);
	Students getStudentById(Long id);
	Students updateStudent(Students students);
	void deleteStudentById(Long id);
}
