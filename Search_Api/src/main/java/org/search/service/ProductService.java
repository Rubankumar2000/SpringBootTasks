package org.search.service;

import java.util.List;

import org.search.entity.Product;
import org.search.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> searchProducts(int query){
		return productRepository.searchProducts(query);
	}

	public List<Product> createProduct(List<Product> product) {
		return productRepository.saveAll(product);
	}

}
