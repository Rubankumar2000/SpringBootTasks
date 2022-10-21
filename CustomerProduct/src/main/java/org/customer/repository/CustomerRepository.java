package org.customer.repository;

import java.util.List;

import org.customer.dto.CustomerDto;
import org.customer.dto.OrderRequest;
import org.customer.dto.OrderResponse;
import org.customer.dto.ProductDto;
import org.customer.dto.customerdtoInterface;
import org.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select new org.customer.dto.OrderResponse(c.id as customerID,c.name as customerName,p.pid as productId,p.pName as product,p.price as price) from Customer c right join c.products p")
	public List<OrderResponse> getOrderInfo();

	@Query("select new org.customer.dto.OrderResponse(c.id as customerID,c.name as customerName,p.pid as productId,p.pName as product,p.price as price) from Customer c right join c.products p where c.id=?1")
	public List<OrderResponse> getOrderInfoById(int customerId);
	
	@Query("select new org.customer.dto.ProductDto(p.pid,p.pName,p.price) from Customer c right join c.products p")
	public List<ProductDto> getProduct();
	
	//@Query
//	@Query("select new org.customer.dto.CustomerDto(c.id ,c.name,p.pid,p.pName,p.price) from Customer c join c.products p")
//	public List<CustomerDto> getAllOrder();
	
	@Query(value="select c.id as id,c.name as name, p.pid as pid,p.p_name as pName,p.price as price,p.qty as qty from customer as c right join product as p on c.id=p.cp_fk",nativeQuery = true)
	public List<customerdtoInterface> getAll();
	
	//public List<CustomerDto> findAllProductByCustomer();
//	@Query("select new org.customer.dto.ProductDto(p.pid,p.pName,p.price) from c.products p")
//	public List<ProductDto> getProduct();
}
