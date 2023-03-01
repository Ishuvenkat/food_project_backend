package com.example.demo.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = CommonException.class)
	public ResponseEntity<ErrorResponse> exception(CommonException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(exception.getStatus());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setHttpstatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
}
