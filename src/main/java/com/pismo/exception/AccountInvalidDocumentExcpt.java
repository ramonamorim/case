package com.pismo.exception;

import org.springframework.http.HttpStatus;

public class AccountInvalidDocumentExcpt extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String INVALID_DOCUMENT = "O Número de Documento informado é inválido.";

	public AccountInvalidDocumentExcpt(String message) {
		super(message);
	}

}
