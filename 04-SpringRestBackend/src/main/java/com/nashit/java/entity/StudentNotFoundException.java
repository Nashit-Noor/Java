package com.nashit.java.entity;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException() {}
	
	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
