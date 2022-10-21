package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private int pid;
	private String pName;
	private int qty;
	private float price;

}
