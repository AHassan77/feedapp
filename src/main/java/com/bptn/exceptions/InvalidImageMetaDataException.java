package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidImageMetaDataException extends Exception {

	public InvalidImageMetaDataException() {
		super();
		
	}

	public InvalidImageMetaDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidImageMetaDataException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidImageMetaDataException(String message) {
		super(message);
		
	}

	public InvalidImageMetaDataException(Throwable cause) {
		super(cause);
		
	}
	
	
}
