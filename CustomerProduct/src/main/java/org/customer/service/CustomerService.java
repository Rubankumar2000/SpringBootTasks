//package org.customer.service;
//
//import org.customer.dto.CustomerDto;
//import org.customer.dto.ProductDto;
//import org.customer.entity.Customer;
//import org.customer.entity.Product;
//import org.customer.repository.CustomerRepository;
//import org.customer.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerService {
//	@Autowired
//	private CustomerRepository customerRepository;
//	@Autowired
//	private ProductRepository productRepository;
//	
//	public CustomerDto entityToDto(Customer customer) {
//		CustomerDto cd=new CustomerDto();
//		cd.setId(customer.getId());
//		cd.setName(customer.getName());
//		cd.setProduct(customer.get);
//	}
//
//}
