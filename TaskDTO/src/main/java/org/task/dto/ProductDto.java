package org.task.dto;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
public class ProductDto {
	@JsonValue
	private String product_name;

}
