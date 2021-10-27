package com.pismo.exception;

import org.springframework.http.HttpStatus;

public class AccountNotFoundExcpt extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MESSAGE = "Conta com o id %d não encontrada.";

	public AccountNotFoundExcpt(Long id) {
		super(HttpStatus.NOT_FOUND, String.format(MESSAGE, id), id);
	}

}
