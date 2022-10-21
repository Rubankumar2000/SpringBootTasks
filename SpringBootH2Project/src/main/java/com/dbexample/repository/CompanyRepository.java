package com.dbexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbexample.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	

}
