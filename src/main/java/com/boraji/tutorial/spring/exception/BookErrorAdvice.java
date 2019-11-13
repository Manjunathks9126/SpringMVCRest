package com.boraji.tutorial.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class BookErrorAdvice {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BookBadRequestException.class})
    public ResponseEntity<?> handle(BookBadRequestException ex) throws IOException {
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(),HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler({BookNotFoundException.class})
	public ResponseEntity<?>handleNotFound(BookNotFoundException ex){
		ErrorResponse r=new ErrorResponse(HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
	}

}
