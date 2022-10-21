package org.sms;

import org.sms.entity.Students;
import org.sms.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public void run(String... args) throws Exception {
		
		 
//		Students students1=new Students("Ben", "CSE", "England");
//		studentsRepository.save(students1);
//		Students students2=new Students("John", "EEE", "Australia");
//		studentsRepository.save(students2);
//		Students students3=new Students("Mathew", "ECE", "German");
//		studentsRepository.save(students3);
//	
	}

}
