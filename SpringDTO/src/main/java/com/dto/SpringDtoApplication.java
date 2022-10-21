package com.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dto.entity.Bus;
import com.dto.entity.Passanger;
import com.dto.repository.BusRepository;
import com.dto.repository.PassangerRepository;

@SpringBootApplication
public class SpringDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDtoApplication.class, args);
	}
	
}
