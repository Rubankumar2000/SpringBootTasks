package org.customer.controller;

import java.util.List;

import javax.persistence.criteria.Order;

import org.customer.dto.CustomerDto;
import org.customer.dto.OrderRequest;
import org.customer.dto.OrderResponse;
import org.customer.dto.ProductDto;
import org.customer.dto.customerdtoInterface;
import org.customer.entity.Customer;
import org.customer.repository.CustomerRepository;
import org.customer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/findAll/{id}")
	public Customer findAllById(@PathVariable int id) {
		return customerRepository.findById(id).get();
	}
	
//	@GetMapping("/find")
//	public List<CustomerDto> getAll() {
//		return customerRepository.find;
//	}

	@GetMapping("/getInfo")
	public List<OrderResponse> getOrderInfo(){
		return customerRepository.getOrderInfo();
	}
	@GetMapping("/getAll")
	public List<customerdtoInterface> getAllOrder(){
		return customerRepository.getAll();
	}
	
	@GetMapping("/getInfo/{customerId}")
	public List<OrderResponse> getOrderInfoById(@PathVariable int customerId){
		return customerRepository.getOrderInfoById(customerId);
	}
	@GetMapping("/getProduct")
	public List<ProductDto> getProduct(){
		return customerRepository.getProduct();
	}
}
