package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		Account account = new Account();
		account.setLevel("Platnium");
		account.setName("Kevin");
		accountDao.addAccount(account, true);
		accountDao.doWork();
		
		accountDao.setName("name");
		accountDao.setServiceCode("sc");
		
		String name = accountDao.getName();
		String code = accountDao.getServiceCode();
		
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

		membershipDao.addThisAccount();
		
		context.close();
	}

}
