package org.rest.controller;

import java.util.List;

import org.rest.model.Student;
import org.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	RestTemplate rest = new RestTemplate();

	@PostMapping("/save") // Jenish
	public List<Student> saveAllStudent(@RequestBody List<Student> students) {
		// System.out.println("Hit by Salvation....."+students);
		return studentService.saveAllStudent(students);
	}

	@GetMapping("/get")
	public ResponseEntity<Student> getAll() {
		return studentService.getAll();
	}

	@PostMapping("/rest/save") // Hijore
	public ResponseEntity<Student[]> saveRest(@RequestBody List<Student> students) {
		return studentService.saveRest(students);
	}

	@DeleteMapping("/delete")
	public String deleteRest() throws Exception {

		// student.setStudent_id(count);
		return studentService.getAllDetails();
	}
}
