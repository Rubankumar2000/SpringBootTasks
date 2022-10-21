package com.dbexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbexample.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees(List<String> dept,String eName);
	Employee getEmployeeBydId(int eID);
	Employee updateEmployee(Employee employee, int eID);
	void deleteEmployee(int eID);
	List<Employee> getById(int id,String ename);
	List<Employee> getEmp(int id);
	List<Employee> getAll();
	List<Employee> saveAllEmp(List<Employee> employee);
	List<Employee> updateEmp(List<Employee> updateEmp);
	void deleteEmp(List<Employee> employee);
	void saveEmp(int eID,String eName,String dept);
	void delEmp(int id);
	void updateEmp(int id,String eName,String dept);
	void createEmp1();
	void dropEmp1();
}
