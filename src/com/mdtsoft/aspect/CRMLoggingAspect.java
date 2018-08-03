package com.mdtsoft.aspect;

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
		
	}
	
	// add @AfterReturning advice
}
