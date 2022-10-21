package com.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	@Column(name = "student_name")
	private String sName;
	@Column(name = "student_age")
	private int sAge;
	@Column(name = "student_total_mark")
	private int total;
	@Column(name = "student_average")
	private float avge;
	

	public Student() {
		super();
	}
	
	public Student(int sId,String sName, int sAge, int total, float avge) {
		super();
		this.sName = sName;
		this.sAge = sAge;
		this.total = total;
		this.avge = avge;
	}
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	
}
