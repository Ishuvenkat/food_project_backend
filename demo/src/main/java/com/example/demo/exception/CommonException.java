package com.example.demo.exception;


@SuppressWarnings("serial")
public class CommonException extends RuntimeException {
	
	private int status;
	private String message;
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
	public CommonException(int status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}
	
	

}
