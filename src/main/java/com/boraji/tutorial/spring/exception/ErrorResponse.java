package com.boraji.tutorial.spring.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse
{
	private String statusCode;
	private HttpStatus status;
	private String message;
	public ErrorResponse(String statusCode, HttpStatus status, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
