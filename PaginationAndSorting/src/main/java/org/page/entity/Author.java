package org.page.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author {
	private int postId;
	@Id
	private int id;
	private String name;
	private String email;
	private String body;

}
