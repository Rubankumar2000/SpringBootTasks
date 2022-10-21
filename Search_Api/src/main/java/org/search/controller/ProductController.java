package org.search.controller;

import java.util.List;

import org.search.entity.Product;
import org.search.repository.CustomerRepository;
import org.search.repository.ProductRepository;
import org.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/search/{id}")
	public ResponseEntity<List<Product>> searchProduct(@PathVariable("id") int query){
		return ResponseEntity.ok(productService.searchProducts(query));
	}
	
	@PostMapping
	public List<Product> createProduct(@RequestBody List<Product> product){
		return productService.createProduct(product);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id ,@RequestBody Product product){
		Product productId = productRepository.findById(id).get();
		productId.setName(product.getName());
		productId.setDescription(product.getDescription());
		productId.setActive(product.getActive());
		return ResponseEntity.ok(productRepository.save(productId));
	}
	
	@GetMapping("/header")
	public ResponseEntity<List<Product>> getProduct() {
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", "Rubankumar");
		List<Product> product = productRepository.findAll();
		return ResponseEntity.ok().headers(header).body(product);
	}

}
