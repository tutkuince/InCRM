package com.mdtsoft.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	// setup pointcut declarations
	@Pointcut("execution(* com.mdtsoft.controller.*.*(..))")
	public void forControllerPackage() {

	}

	@Pointcut("execution(* com.mdtsoft.service.*.*(..))")
	public void forServicePackage() {

	}

	@Pointcut("execution(* com.mdtsoft.dao.*.*(..))")
	public void forDAOPackage() {

	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {
		
	}
}
