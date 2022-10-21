package com.dto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="passanger")
public class Passanger {
	@Id
	private int pId;
	@Column(name = "passanger_name")
	private String pName;
//	private long busId;
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id")
	private Bus bus;

}
