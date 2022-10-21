package com.dto.Dto;

import lombok.Data;

@Data
public class BusPassangerDto {
	private long busId;
	private String busName;
	private long pId;
	private String pName;
	private String departs;
	private String arrives;

}
