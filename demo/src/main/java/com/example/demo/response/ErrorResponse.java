package com.example.demo.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private int status;
	private String message;
	private HttpStatus httpstatus;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	
	
	
	

}
