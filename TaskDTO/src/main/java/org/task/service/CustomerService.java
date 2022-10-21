package org.task.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.task.dto.CustomerDto;
import org.task.model.Customer;
import org.task.model.Product;
import org.task.repository.CustomerRepository;
import org.task.repository.ProductRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public List<CustomerDto> getAllDetails() {
		return productRepository.findAll()
				.stream()
				.map(e->entityToDto(e))
				.collect(Collectors.toList());
	}
	
	public CustomerDto getData(int id) {
		return this.entityToDto(productRepository.getById(id));
	}
	
	public CustomerDto entityToDto(Product product) {
		CustomerDto cd=new CustomerDto();
		cd.setId(product.getCustomer().getId());
		cd.setCust_id(product.getCustomer().getCust_id());
		cd.setName(product.getCustomer().getName());
		cd.setAddress(product.getCustomer().getAddress());
		cd.setProduct(product.getProduct_name());
		return cd;
	}
	
//	public List<CustomerDto> getAllCustomer() {
//		return customerRepository.findAll().
//	}

}
