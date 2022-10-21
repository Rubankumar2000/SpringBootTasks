package org.task.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
	@Id
	private int pid;
	private String product_name;
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Customer customer;
}
