package com.pismo.exception;

import org.springframework.http.HttpStatus;

public class AccountInvalidDocumentExcpt extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MESSAGE = "Documento informado %d é inválido.";

	public AccountInvalidDocumentExcpt(String documentNumber) {
		super(HttpStatus.NOT_FOUND, String.format(MESSAGE, documentNumber), documentNumber);
	}

}
