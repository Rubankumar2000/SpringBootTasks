package org.search.repository;

import java.util.List;

import org.search.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.id=:query")
	List<Product> searchProducts(int query);

}
