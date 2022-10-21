package com.crud.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Scheduled(fixedDelay = 1000)
	public void scheduleTask() {
		System.out.println("schedula task time--");
	}
	
	@Scheduled(cron = "*/1 * * * * *")
	public void cronExp() {
		System.out.println("cron expression task time--");
	}
	
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	
	//save list of student details
	@PostMapping("/saveAll")
	public List<Student> saveAllStudent(@RequestBody List<Student> student) {
		return studentService.saveAllStudent(student);
	}
	//get the one student details
	@GetMapping("/get")
	public Student getStudent() {
		return new Student(1,"Ruban",22,440,88);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudent() {
		logger.info("Get All value ");
		return studentService.getAllStudent();
	}
	
	@PutMapping("/updateAll")
	public List<Student> updateAllStudent(@RequestBody int sId,@RequestBody List<Student> student) {
		return studentService.updateAllStudent(sId,student);
	}

}
