package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accounts = null;
		
		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception ex) {
			System.out.println("main exception" + ex);
		}
		
		System.out.println("After throwing demo app");
		System.out.println(accounts);
		
		context.close();
	}

}
