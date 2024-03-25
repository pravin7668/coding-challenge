package com.exception;

public class InvalidSalaryException extends Exception {
	private String message;
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return message;
	}

	public InvalidSalaryException(String message) {
		super();
		this.message = message;
	}

	

}
