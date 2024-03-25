package com.exception;

public class InvalidEmailException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidEmailException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
