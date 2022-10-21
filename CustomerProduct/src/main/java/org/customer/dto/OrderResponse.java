package org.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class OrderResponse {
	private String customerName;
	private int customerId;
	private int productId;
	private String productName;
	private int price;
	public OrderResponse(int id,String name, int pid, String pName, int price) {
		super();
		this.customerName = name;
		this.customerId = id;
		this.productId = pid;
		this.productName = pName;
		this.price = price;
	}
	

}
