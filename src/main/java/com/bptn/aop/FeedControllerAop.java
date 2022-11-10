package com.bptn.aop;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// We use the @Aspect declaration
@Aspect // Tells Spring we are using Aspect Oriented programming
@Component // If you have spring project that not the following
// repository access to database
// Service is business logic
// Controller Not receiving request
// Then you put it as a Component
public class FeedControllerAop {
	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//@Autowired
	//serservice userservice
	
    @Autowired
    HttpServletRequest request;

    // Here, we tell our aspect that its execution will happen @Around the time of the joinpoint given in the following line.
    @Around("execution(* com.bptn.controller.FeedController.*(..))")
    // Around: We want to have access before and after we run the method
    // Before Just want access before we run the method does not care about after
    // After Does not care about before wants to know after
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    	// joinPoint gives access to
    	Map<String,String[]> map =request.getParameterMap();
    	
    	logger.debug("Controller Executing : " + joinPoint.getSignature());
    	
    	//joinpoint.getSignature: Name fo method we intercepted
    	
    	if (!map.isEmpty()) {
    		logger.debug("Parameters Received:");
    		map.forEach((k,v) -> logger.debug("{}-> {}",k,v));
    	}
    	
    	Object[] args = joinPoint.getArgs();

    	if ( args.length>0 ) {
    		
    		logger.debug("Arguments Received: {}", Arrays.toString(args)); 
    	}
    	// Arrays.toString :Going to print username
    	
    	// validUser()

    	//this.userService.validateUserId(args[0].toString());
    	Object value = null;
        try {

        	value = joinPoint.proceed(); // We intercepted method before and now we
        								// execute using proceed method
        	
        	if (value instanceof List) {
        		
        		List<?> list = (List<?>)value;
     		
        		//Limit the size of list to 20 element max to avoid flooding the console.
        		logger.debug("Return Value: {}", list.stream().limit(20).toList());
        	} else {        		
        		logger.debug("Return Value: {}", value);
        	}

        } finally {
            //Do Something useful If you have to
        }
        
        logger.debug("Controller Ended Execution : " + joinPoint.getSignature());
        
        return value;
    }
    
}