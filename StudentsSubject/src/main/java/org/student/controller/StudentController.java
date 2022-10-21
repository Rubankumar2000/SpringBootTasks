package org.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.dto.StudentDto;
import org.student.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAll")
	public List<StudentDto> getAllDetail() {
		return studentService.getAllDetail();
	}
	@GetMapping("/stu/{stuId}")
	public StudentDto getById(@PathVariable int stuId) {
		return studentService.getById(stuId);
	}

	@JS
//	@GetMapping("/sub/{subId}")
//	public StudentDto getData(@PathVariable int subId) {
//		return studentService.getData(subId);
//	}
}
