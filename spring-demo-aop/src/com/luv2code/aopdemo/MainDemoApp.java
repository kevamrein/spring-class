package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		accountDao.addAccount();
		
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

		membershipDao.addThisAccount();
		
		context.close();
	}

}
