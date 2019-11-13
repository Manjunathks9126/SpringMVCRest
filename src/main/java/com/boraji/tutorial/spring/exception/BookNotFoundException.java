package com.boraji.tutorial.spring.exception;

public class BookNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
