package com.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Data
@Entity
@Table(name="buses")
public class Bus {
	@Id
	private long busId;
	@Column(name="bus_name")
	private String busName;
	private String departs;
	private String arrives;
	@Column(name = "driver_name")
	private String dName;

}
