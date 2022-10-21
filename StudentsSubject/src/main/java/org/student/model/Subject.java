package org.student.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subject")
public class Subject {
	@Id
	private int subId;
	private String subName;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Student student;
}
