package com.pismo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {

	@JsonProperty("account_id")
	private Long id;

	@NotNull
	@Pattern(regexp = "^([0-9]{11}|[0-9]{14})$")
	@JsonProperty("document_number")
	private String documentNumber;
	
}
