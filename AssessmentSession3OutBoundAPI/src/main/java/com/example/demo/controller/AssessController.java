package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AssessController {
	
	RestTemplate rest=new RestTemplate();
	String url="http://192.168.0.62:8086/header";
	
	@GetMapping("/assess")
	public ResponseEntity<String> getAssess() {
		ResponseEntity<String> entity = rest.getForEntity(url, String.class);
		if(entity.getBody().equals("8ad68130835f32de01835f332a650000")) {
			System.out.println("Matched");
		}
		else {
			System.out.println("Not matched");
		}
		System.out.println(entity.getHeaders());
		return entity;
	}

}
