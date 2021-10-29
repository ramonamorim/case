package com.pismo.exception;

public class TransactionExcpt extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String MESSAGE = "Limite de crédito excedido.";

	public TransactionExcpt() {
		super(String.format(MESSAGE));
	}

}
