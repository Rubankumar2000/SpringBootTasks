package com.dto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Dto.BusPassangerDto;
import com.dto.entity.Passanger;
import com.dto.service.BusService;

@RestController
public class BusController {
	@Autowired
	private BusService busService;
	
	@GetMapping("/bus")
	public List<BusPassangerDto> getAllDetails() {
		return busService.getAllDetails();
	}
	
	@PostMapping("/saveDetails")
	public List<Passanger> saveAllDetails(@RequestBody List<Passanger> passanger) {
		return busService.saveAllDetails(passanger);
	}
	

}
