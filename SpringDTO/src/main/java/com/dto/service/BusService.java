package com.dto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Dto.BusPassangerDto;
import com.dto.entity.Bus;
import com.dto.entity.Passanger;
import com.dto.repository.BusRepository;
import com.dto.repository.PassangerRepository;

@Service
public class BusService {
	@Autowired
	private PassangerRepository passangerRepository;

	@Autowired
	private BusRepository busRepository;
	
	public List<BusPassangerDto> getAllDetails() {
		return passangerRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
	}
	
	private BusPassangerDto convertEntityToDto(Passanger Passanger) {
		BusPassangerDto busPassangerDto=new BusPassangerDto();
		busPassangerDto.setBusId(Passanger.getBus().getBusId());
		busPassangerDto.setPName(Passanger.getPName());
		busPassangerDto.setPId(Passanger.getPId());
		busPassangerDto.setArrives(Passanger.getBus().getArrives());
		busPassangerDto.setBusName(Passanger.getBus().getBusName());
		busPassangerDto.setDeparts(Passanger.getBus().getDeparts());
		return busPassangerDto; 
	}

	public List<Passanger> saveAllDetails(List<Passanger> passanger) {
		return passangerRepository.saveAll(passanger);
	}
}
