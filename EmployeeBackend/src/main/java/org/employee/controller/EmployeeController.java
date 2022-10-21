package org.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.employee.exception.ResourceNotFoundException;
import org.employee.model.Employee;
import org.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@PostMapping("/save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PostMapping("/saveAll")
	public List<Employee> createAllEmployee(@RequestBody List<Employee> employees){
		return employeeRepository.saveAll(employees);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee Id doesn't exist: "+id));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) throws InterruptedException{
//		Thread.sleep(5000);
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee id doesn't exist"+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee emplyee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee id doesn't exist: "+id));
		employeeRepository.delete(emplyee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
