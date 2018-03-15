package com.sunlands.rpc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
	private Logger logger = LoggerFactory.getLogger(LogAop.class);

	ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Pointcut("execution(* com.sunlands.rpc.*.handler.*.* (..))")
	public void log(){}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("method {} begin", joinPoint.getSignature().toShortString());
		startTime.set(System.nanoTime());
	}

	@After("log()")
	public void doAfter(JoinPoint joinPoint){
		long endTime = System.nanoTime();
		long executeTime = (endTime - startTime.get()) / 1000000;
		logger.info("method {} end, execute {} ms", joinPoint.getSignature().toShortString(), executeTime);
	}

}
