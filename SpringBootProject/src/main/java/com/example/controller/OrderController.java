package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.request.OrderRequest;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
		
	@PostMapping("/post")
	public Customer postCustomer(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findall")
	public List<Customer> findAllOrder() {
		return customerRepository.findAll();
	}

}
