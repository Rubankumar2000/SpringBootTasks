package org.jwt.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String gender;
	private int loginCount;
	private boolean status = true;
	private String ssoType;
	@CreationTimestamp
	private LocalDateTime loginAt;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;
	

	@PrePersist
	public void onSave() {
		Date currentDate = new Date();
		this.createdAt = currentDate;
		this.updatedAt = currentDate;
	}
	
	@PostPersist
	public void onUpdate() {
		Date currentDate = new Date();
		this.updatedAt = currentDate;
	}

}
