package com.employee.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("selectedAdvise()")
	public void logBeforeAdvise() {
		System.out.println("Log method is executed before buisness method");
	}
	//@After("selectedAdvise()")
	public void logAfterAdvise() {
		System.out.println("Log method is executed After buisness method");
	}
	//@Pointcut("execution(public void employeeDetails()) ")
	public void selectedAdvise() {}
}
