package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/header")
	public ResponseEntity<String> headerEmp(HttpServletResponse response) {
		 HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.set("outboundkey", 
		      "8ad68130835f32de01835f332a650000");

		    return ResponseEntity.ok()
		      .headers(responseHeaders)
		      .body("Response with header using ResponseEntity");
	}

}
