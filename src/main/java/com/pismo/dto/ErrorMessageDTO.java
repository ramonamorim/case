package com.pismo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessageDTO {

	public ErrorMessageDTO(int statusCode, Date timestamp, String message, String description) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.path = description;
	}

	@JsonProperty("statusCode")
	private int statusCode;
	
	@JsonProperty("timestamp")
	private Date timestamp;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("path")
	private String path;
}
