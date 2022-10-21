package org.customer.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int pid;
	private String pName;
	private int price;
	public ProductDto(int pid, String pName, int price) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.price = price;
	}
	
	

}
