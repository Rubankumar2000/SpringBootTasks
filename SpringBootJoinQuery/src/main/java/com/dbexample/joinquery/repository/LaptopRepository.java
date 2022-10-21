package com.dbexample.joinquery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbexample.joinquery.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	
	
}
