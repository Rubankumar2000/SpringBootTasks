package org.rest.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String first_name;
	private String last_name;
	private int student_age;
	private String address;
	private int pin_code;
	private long phone_number;
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime modified_date;

}
