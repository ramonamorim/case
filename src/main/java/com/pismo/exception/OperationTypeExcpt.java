package com.pismo.exception;

import org.springframework.http.HttpStatus;

public class OperationTypeExcpt extends GenericException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Operação de código %d não encontrada.";

	public OperationTypeExcpt(Long id) {
		super(HttpStatus.NOT_FOUND, String.format(MESSAGE, id), id);
	}

}
