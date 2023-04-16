package com.hdfc.olms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
/**
 *@author Bharath Kumar
 *@created 14-Apr-2023
*
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HttpClientErrorException.class)
	ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
