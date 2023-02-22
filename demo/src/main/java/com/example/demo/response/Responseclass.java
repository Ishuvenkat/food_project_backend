package com.example.demo.response;

public class ResponseClass {

	private int status;
	private String message;

	public ResponseClass(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseClass() {
	}

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

}
