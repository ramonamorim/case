package com.pismo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pismo.dto.ErrorMessageDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler  {
	
	
	  @ExceptionHandler(AccountNotFoundExcpt.class)
	  public ResponseEntity<ErrorMessageDTO> resourceNotFoundException(AccountNotFoundExcpt ex, WebRequest request) {
	    ErrorMessageDTO message = new ErrorMessageDTO(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(OperationTypeExcpt.class)
	  public ResponseEntity<ErrorMessageDTO> resourceNotFoundException(OperationTypeExcpt ex, WebRequest request) {
	    ErrorMessageDTO message = new ErrorMessageDTO(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(TransactionExcpt.class)
	  public ResponseEntity<ErrorMessageDTO> resourceNotFoundException(TransactionExcpt ex, WebRequest request) {
	    ErrorMessageDTO message = new ErrorMessageDTO(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(AccountInvalidDocumentExcpt.class)
	  public ResponseEntity<ErrorMessageDTO> resourceNotFoundException(AccountInvalidDocumentExcpt ex, WebRequest request) {
	    ErrorMessageDTO message = new ErrorMessageDTO(
	        HttpStatus.BAD_REQUEST.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.BAD_REQUEST);
	  }
	  
}
	  
	  

