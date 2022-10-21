package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="customer_name")
	private String name; 
	@Column(name = "phone_number")
	private String phoneNumer;
	
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk",referencedColumnName = "id")
	private List<Product> product;
}
