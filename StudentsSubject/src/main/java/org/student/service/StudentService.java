package org.student.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.student.dto.StudentDto;
import org.student.dto.SubjectDto;
import org.student.model.Student;
import org.student.model.Subject;
import org.student.repository.StudentRepo;
import org.student.repository.SubjectRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private SubjectRepo subjectRepo;
	
	public List<StudentDto> getAllDetail() {
		return studentRepo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
	}
	public StudentDto getById(int stuId) {
		return this.entityToDto(studentRepo.getById(stuId));
	}
	
	public StudentDto entityToDto(Student student) {
		StudentDto sd=new StudentDto();
		sd.setStuId(student.getStuId());
		sd.setName(student.getName());
		sd.setAddress(student.getAddress());
		sd.setSubName(student.getSubject());
//		sd.setSubName(student.getSubject().getSubName());
//		sd.setSubName(Arrays.asList(new SubjectDto(), new SubjectDto()));
		return sd;
		
	}
//	public StudentDto subjectEntityToDto(Subject subject) {
//		StudentDto ss=new StudentDto();
//		ss.setStuId(subject.getStudent().getStuId());
//		ss.setName(subject.getStudent().getName());
//		ss.setAddress(subject.getStudent().getAddress());
//		ss.setSubName(subject.getSubName());
////		ss.setSubName(Arrays.asList(new SubjectDto(), new SubjectDto()));
//		return ss;
//	}
//
//	public StudentDto getData(int subId) {
//		return this.subjectEntityToDto(subjectRepo.getById(subId));
//	}

}
