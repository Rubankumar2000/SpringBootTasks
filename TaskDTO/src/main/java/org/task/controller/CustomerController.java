package org.task.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.dto.CustomerDto;
import org.task.model.Customer;
import org.task.model.Product;
import org.task.service.CustomerService;
import org.task.service.ProductService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	
//	@GetMapping("{id}")
//	public List<CustomerDto> getAll() {
//		return customerService.getAllCustomer();
//	}
	
	@GetMapping("/getAll")
	public List<CustomerDto> getAllDetails() {
		System.out.println("hi");
		return customerService.getAllDetails();
	}
	
	@GetMapping("{id}")
	public CustomerDto getData(@PathVariable int id) {
		return customerService.getData(id);
	}

}
