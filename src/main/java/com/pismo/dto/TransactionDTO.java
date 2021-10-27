package com.pismo.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDTO {

	@NotNull
	@JsonProperty("account_id")
	private Long account;

	@NotNull
	@JsonProperty("operation_type_id")
	private Long operationType;

	@NotNull
	@JsonProperty("amount")
	private BigDecimal amount;
}
