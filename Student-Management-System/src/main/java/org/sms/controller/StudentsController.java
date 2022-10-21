package org.sms.controller;

import org.sms.entity.Students;
import org.sms.service.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentsController {
	private StudentsService studentsService;

	public StudentsController(StudentsService studentsService) {
		super();
		this.studentsService = studentsService;
	}
	
	//handler method to handle list of students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentsService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Students students=new Students();
		model.addAttribute("student",students);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Students students) {
		studentsService.saveStudents(students);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("students",studentsService.getStudentById(id));
		return "edit_students";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("students") Students students, Model model) {
		Students existingStudent=studentsService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(students.getName());
		existingStudent.setDept(students.getDept());
		existingStudent.setAddress(students.getAddress());
		
		studentsService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/dlt/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentsService.deleteStudentById(id);
		return "redirect:/students";
	}
}
