package com.team2.his.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
public class BaseModel {

	private Integer statusCode;
	private String message;

	public BaseModel(Integer statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
}
