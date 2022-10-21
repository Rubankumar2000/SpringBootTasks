package com.dbexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employees") 
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eID; 
	@Column(name="employee_name")
	private String eName;
	@Column(name="department")
	private String dept;
	
	public Employee(int eID, String eName, String dept) {
		super();
		this.eID = eID;
		this.eName = eName;
		this.dept = dept;
	}
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Employee() {
	}

}
