package com.bptn.exceptions;

public class InvalidUserCredentialsException extends Exception {

	public InvalidUserCredentialsException() {
		super();
		
	}

	public InvalidUserCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidUserCredentialsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidUserCredentialsException(String message) {
		super(message);
		
	}

	public InvalidUserCredentialsException(Throwable cause) {
		super(cause);
		
	}
	

}
