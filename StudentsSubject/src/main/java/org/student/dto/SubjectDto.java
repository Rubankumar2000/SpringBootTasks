package org.student.dto;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
public class SubjectDto {
	@JsonValue
	private String subName;

	public SubjectDto(String subName) {
		super();
		this.subName = subName;
	}

}
