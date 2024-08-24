package com.nashit.java.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nashit.java.entity.ErrorResponse;
import com.nashit.java.entity.StudentNotFoundException;

@RestControllerAdvice
public class MyCustomHandler extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException snfe){
		
		ErrorResponse body = new ErrorResponse(new Date().toString(), snfe.getMessage(), "500");
		return new ResponseEntity<ErrorResponse>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
