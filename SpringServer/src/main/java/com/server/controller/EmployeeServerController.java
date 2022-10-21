package com.server.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee/server")
public class EmployeeServerController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAll")
	public List<Object> getAllEmployees(){
		Object[] object = restTemplate.getForObject("http://localhost:8080/employees/all", Object[].class);
		return Arrays.asList(object);
	}

}
