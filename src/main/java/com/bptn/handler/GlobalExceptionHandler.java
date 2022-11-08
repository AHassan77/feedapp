package com.bptn.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserNameException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@ExceptionHandler(Exception.class) // handles all our exceptions
	@ExceptionHandler(InvalidUserNameException.class) //you can also pass whatever exception you want
	public ResponseEntity<String> handleInvalidUserExceptions(Exception ex, WebRequest request){
		
		/* WebRequest is the datatype
		 Whenever an exception happens in any of our controller
			will use logger to log exception and send a bad request
			In order to make it work we need an annotation @ControllerAdvice
			Spring creates object of ControllerAdvice
			If you are not controlling exception from controller this will catch the exception
			*/
	
		logger.debug("Error with the username");
		logger.debug(ex.getMessage(),ex);	
		
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<String> handleInvalidRequestExceptions(Exception ex, WebRequest request){
		
		logger.debug(ex.getMessage(),ex);
		
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
