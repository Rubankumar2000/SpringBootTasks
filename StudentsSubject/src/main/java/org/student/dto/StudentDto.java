package org.student.dto;

import java.util.List;

import org.student.model.Subject;

import lombok.Data;

@Data
public class StudentDto {
	private int stuId;
	private String name;
	private String address;
	private List<Subject> subName;

}
