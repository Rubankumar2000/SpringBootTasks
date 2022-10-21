package com.dbexample.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbexample.exception.ResourceNotFoundException;
import com.dbexample.model.Employee;
import com.dbexample.repository.EmployeeRepository;
import com.dbexample.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees(List<String> dept,String eName) {
		if(dept==null) {
			return employeeRepository.findAll();
		}
		else {
			return employeeRepository.findAllByDeptInAndEName(dept,eName);
		}
//		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeBydId(int eID) {
		Optional<Employee> employee=employeeRepository.findById(eID);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "ID", eID);
		}
		
	}


	@Override
	public Employee updateEmployee(Employee employee, int eID) {
		//we need to check whether the employee id is exist in DB or not
		Employee existEmployee=employeeRepository.findById(eID).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",eID));
		existEmployee.seteName(employee.geteName());
		existEmployee.setDept(employee.getDept());
		//save existing employee to DB
		employeeRepository.save(existEmployee);
		return existEmployee;
	}

	@Override
	public List<Employee> updateEmp(List<Employee> updateEmp) {
		List<Employee> oldEmp = employeeRepository.findAll();
		for (Employee newOne : updateEmp) {
			for (Employee oldOne : oldEmp) {
				if(newOne.geteID()==oldOne.geteID()) {
					oldOne.seteName(newOne.geteName());
					oldOne.setDept(newOne.getDept());
				}	
			}
		}
		return employeeRepository.saveAll(oldEmp);
	}

	@Override
	public void deleteEmployee(int eID) {
		//check whether a employee existing a DB or not
		employeeRepository.findById(eID).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", eID));
		employeeRepository.deleteById(eID);
	}
	
	@Override
	public void deleteEmp(List<Employee> employee) {
		List<Employee> oldEmp=employeeRepository.findAll();
		for (Employee deleteOneOld : oldEmp) {
			for (Employee deleteOneNew : employee) {
				if (deleteOneNew.geteName().equals(deleteOneOld.geteName())) {
					employeeRepository.delete(deleteOneOld);
				}
			}
		}
		
	}

	@Override
	public List<Employee> getById(int id,String ename) {
		return employeeRepository.getId(id,ename);
	}


	@Override
	public List<Employee> getEmp(int id) {
		return employeeRepository.getEmp(id);
	}


	@Override
	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}


	@Override
	public List<Employee> saveAllEmp(List<Employee> employee) {
		List<Employee> saveAll=new ArrayList<>();
		for (Employee emp : saveAll) {
			saveAll.addAll(employee);
		}
		return employeeRepository.saveAll(employee);
	}


	@Override
	public void saveEmp(int eID,String eName,String dept) {
		employeeRepository.saveEmp(eID,eName,dept);
	}


	@Override
	public void delEmp(int id) {
		employeeRepository.delEmp(id);
	}


	@Override
	public void updateEmp(int id, String eName, String dept) {
		employeeRepository.updateEmp(id, eName, dept);
	}


	@Override
	public void createEmp1() {
		employeeRepository.createEmp1();
	}


	@Override
	public void dropEmp1() {
		employeeRepository.dropEmp1();
	}

	
}
