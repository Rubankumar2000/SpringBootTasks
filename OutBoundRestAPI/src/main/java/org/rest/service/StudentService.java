package org.rest.service;

import java.util.List;

import org.rest.model.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	List<Student> saveAllStudent(List<Student> students);

	ResponseEntity<Student> getAll();

	ResponseEntity<Student[]> saveRest(List<Student> students);

	String deleteRest(int id) throws Exception;
	
	String getAllDetails() throws Exception;

}
