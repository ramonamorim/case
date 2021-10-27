package com.pismo.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String path;
	private final String message;
	private final Object value;
	private final HttpStatus status;

	public GenericException(String message) {
		this(HttpStatus.BAD_REQUEST, null, message, null, null);
	}
	
	public GenericException(HttpStatus httpStatus, String message, Object value) {
		this(httpStatus, null, message, value, null);
	}

	public GenericException(HttpStatus httpStatus, String path, String message, Object value, Throwable cause) {
		super(message, cause);
		this.status = httpStatus;
		this.path = path;
		this.message = message;
		this.value = value;
	}
	
	
}
