package org.customer.dto;

import org.customer.entity.Customer;

import lombok.Data;

@Data
public class OrderRequest {
	private Customer customer;

}
