package org.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.task.dto.CustomerDto;
import org.task.model.Customer;
import org.task.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	//@Query(nativeQuery = true,value = "Select * from Customer c inner join Product p on c.id=p.id")
	//List<Customer> getAllDetails();
	@Query(nativeQuery = true, value = "select * from customer c join product p on c.id=p.id where c.id=?1")
	List<CustomerDto> getDataId(int id);

}
