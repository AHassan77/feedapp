package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidUserNameException extends Exception {

	public InvalidUserNameException() {
		super();
		
	}

	public InvalidUserNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidUserNameException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidUserNameException(String message) {
		super(message);
		
	}

	public InvalidUserNameException(Throwable cause) {
		super(cause);
		
	}	

}
