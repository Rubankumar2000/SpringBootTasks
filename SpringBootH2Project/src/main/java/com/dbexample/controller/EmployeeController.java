package com.dbexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbexample.model.Employee;
import com.dbexample.service.EmployeeService;

import lombok.experimental.PackagePrivate;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	//Get REST API 
	@GetMapping("/get")
	public Employee getEmployeeService() {
		return new Employee(1,"Develop","Ruban");
	}
	
	//create REST APT
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//create REST API(saveAll)
	@PostMapping("/saveall")
	public List<Employee> saveAllEmp(@RequestBody List<Employee> employee) {
		return employeeService.saveAllEmp(employee);
	}

	
	//Get all employees REST API
	@GetMapping("/all")
	public List<Employee> getAllEmployees(@RequestParam(value = "dept", required = false) List<String> dept,
			@RequestParam(value = "eName",required = true) String eName) {
		return employeeService.getAllEmployees(dept,eName);
	}
	//Get employee by id REST API
	@GetMapping()
	public ResponseEntity<Employee> getEmployeeById(@RequestParam(name = "eID",required = true) int eID) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeBydId(eID), HttpStatus.FOUND);
	}
	
	//Update employee REST API
	@PutMapping("{eID}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("eID") int eID,@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, eID),HttpStatus.OK);
	}
	
	//update All employee REST API
	@PutMapping("/updateall")
	public List<Employee> updateAllEmp(@RequestBody List<Employee> updateEmp) {
		return employeeService.updateEmp(updateEmp);
	}
	
	//Delete employee REST API
	@DeleteMapping("{eID}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eID") int eID) {
		//delete employee from DB
		employeeService.deleteEmployee(eID);
		return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
	}
	
	//Delete employee while datas are same 
	@DeleteMapping("delete")
	public void deleteEmp(@RequestBody List<Employee> employee) {
		employeeService.deleteEmp(employee);
	}
	
	
	@GetMapping("/gets")
	public List<Employee> getId(@RequestParam("id") int id,@RequestParam("ename") String ename ) {
		//System.out.println("hi");
		return employeeService.getById(id,ename);
	}
	
	@GetMapping("/getemp")
	public List<Employee> getEmp(@RequestParam("id") int id) {
		return employeeService.getEmp(id);
	}
	
	
	@GetMapping("/getall")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@PostMapping("/saveEmp")
	public void saveEmp(@RequestParam("eID") int eID,@RequestParam("name") String eName,@RequestParam("dept") String dept) {
		employeeService.saveEmp(eID,eName,dept);
	}
	
	@DeleteMapping("/delEmp")
	public void delEmp(@RequestParam("eID")int id) {
		employeeService.delEmp(id);
	}
	
	@PutMapping("/updateEmp")
	public void updateEmp(@RequestParam("eID") int id,@RequestParam("name") String eName,@RequestParam("dept") String dept) {
		employeeService.updateEmp(id,eName,dept);
	}
	
	@PostMapping("/createEmp")
	public void createEmp1() {
		employeeService.createEmp1();
	}
	
	@DeleteMapping("/dropEmp")
	public void dropEmp() {
		employeeService.dropEmp1();
	}

}
