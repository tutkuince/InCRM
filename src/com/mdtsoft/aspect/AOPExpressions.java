package com.mdtsoft.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	// setup pointcut declarations
	@Pointcut("execution(* com.mdtsoft.controller.*.*(..))")
	private void forControllerPackage() {

	}

	@Pointcut("execution(* com.mdtsoft.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.mdtsoft.dao.*.*(..))")
	private void forDAOPackage() {

	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {
		
	}
}
