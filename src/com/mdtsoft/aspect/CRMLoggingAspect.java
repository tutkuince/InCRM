package com.mdtsoft.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// add @Before advice
	@Before("com.mdtsoft.aspect.AOPExpressions.forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("===>>> in @Before: calling method: " + method);
		
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		Arrays.asList(args).stream().forEach(o -> logger.info("======>>>>>> argument: " + o));
	}
	
	// add @AfterReturning advice
}
