package com.example.demo.exceptio;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = commonException.class)
	public ResponseEntity<ErrorResponse> exception(commonException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(exception.getStatus());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
