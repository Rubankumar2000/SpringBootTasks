package org.task.dto;

import java.util.List;

import org.task.model.Product;

import lombok.Data;

@Data
public class CustomerDto {
	private int id;
	private int cust_id;
	private String name;
	private String address;
	private String product;
	
}
