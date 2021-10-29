package com.pismo.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

	@JsonProperty("account_id")
	private Long id;

	@NotNull
	@JsonProperty("document_number")
	private String documentNumber;
	
	@NotNull
	@JsonProperty("avaible_credit_limit")
	private  BigDecimal availableCreditLimit;

}
