package com.mdtsoft.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
	
	// setup pointcut declaration
	@Pointcut("execution(* com.mdtsoft.controller.*.*(..))")
	public void forControllerPackage() {

	}
}
