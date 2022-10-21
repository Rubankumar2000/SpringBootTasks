package com.dbexample.joinquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbexample.joinquery.entity.Brand;
import com.dbexample.joinquery.entity.Laptop;
import com.dbexample.joinquery.repository.LaptopRepository;

@SpringBootApplication
public class SpringBootJoinQueryApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJoinQueryApplication.class, args);
	}
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Laptop lap=new Laptop();
		lap.setName("Lenovo");
		
		Brand brand=new Brand();
		brand.setModel("thinkpad");
		brand.setPrice(50000);
		
		lap.setBrand(brand);
		brand.setLaptop(lap);
		
		laptopRepository.save(lap);
	}


}
