package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		logger.info("executing around on method" + methodSig);
		
		long startTime = System.currentTimeMillis();
		
		Object result = joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - startTime;
		
		logger.info("Duration: " + duration / 1000.0);
		
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccount(JoinPoint joinPoint) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		logger.info("executing after finally on method" + methodSig);
	}
	
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))", throwing = "exc")
	public void afterThrowingFindAccount(JoinPoint joinPoint, Throwable exc) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		logger.info("executing after throwing on method" + methodSig);
		
		logger.info("Advice exception " + exc);
	}
	
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		logger.info("executing after return on method" + methodSig);
		logger.info("Result: " + result);
		
		convertAccountNamesToUppercase(result);
	}
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("Executing Before for add account");
		
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
	
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info(arg.toString());
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				logger.info(account.getName());
				logger.info(account.getLevel());
			}
		}
		logger.info(methodSig.toString());
	}
}
