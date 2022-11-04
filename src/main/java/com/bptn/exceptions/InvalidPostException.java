package com.bptn.exceptions;

public class InvalidPostException extends Exception {

	public InvalidPostException() {
		super();

	}

	public InvalidPostException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidPostException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidPostException(String message) {
		super(message);
		
	}

	public InvalidPostException(Throwable cause) {
		super(cause);
		
	}
	
}
