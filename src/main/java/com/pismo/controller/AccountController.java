package com.pismo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.dto.AccountDTO;
import com.pismo.dto.ErrorMessageDTO;
import com.pismo.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Gerenciamento de Contas")
@Validated
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Operation(summary = "Criar conta", description = "Cria uma conta usando as informações fornecidas.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = AccountDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class))) })

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO accountRequestDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(accountRequestDTO));
	}

	@Operation(summary = "Buscar conta pelo Id", description = "Buscar uma conta usando seu identificador.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = AccountDTO.class))),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class))) })
	@GetMapping(value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDTO> getById(@PathVariable Long accountId) {
		return ResponseEntity.ok(accountService.getAccountById(accountId));
	}

}
