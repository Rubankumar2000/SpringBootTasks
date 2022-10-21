package com.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.entity.Passanger;

public interface PassangerRepository extends JpaRepository<Passanger, Long>{
	
}
