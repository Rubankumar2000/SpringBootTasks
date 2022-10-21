package org.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private int pid;
	private String pName;
	private int qty;
	private int price;

}
