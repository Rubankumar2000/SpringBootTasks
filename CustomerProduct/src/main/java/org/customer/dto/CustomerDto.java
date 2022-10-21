package org.customer.dto;

import java.util.List;

import org.customer.entity.Product;

import lombok.Data;

@Data
public class CustomerDto {
	private int id;
	private String name;
	private int pid;
	private String pName;
}
