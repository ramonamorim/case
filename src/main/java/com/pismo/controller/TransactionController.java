package com.pismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pismo.dto.ErrorMessageDTO;
import com.pismo.dto.TransactionDTO;
import com.pismo.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Component
@RequestMapping("/transactions")
@Tag(name = "Gerenciamento de Transações")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Operation(summary = "Criar Transação", description = "Cria uma transação usando as informações fornecidas.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = TransactionDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class))),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class))) })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO transactionDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transactionDTO));
	}
}
