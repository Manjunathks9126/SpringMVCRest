package com.boraji.tutorial.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookBadRequestException extends RuntimeException{
	public BookBadRequestException(String message) {
		super(message);
		this.message = message;
		System.out.println(message);
	}

	//private HttpStatus statusCode;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
//	public BadRequestException(HttpStatus badRequest, String message) {
//		super();
//		this.statusCode = badRequest;
//		this.message = message;
//	}
//	public HttpStatus getStatusCode() {
//		return statusCode;
//	}
//	public void setStatusCode(HttpStatus statusCode) {
//		this.statusCode = statusCode;
//	}
//	public String getMessage() {
//		return statusCode+","+message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}

	
}
