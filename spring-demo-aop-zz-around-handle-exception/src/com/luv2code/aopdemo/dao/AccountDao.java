package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("EXCEPTION");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		Account account = new Account("Kevin", "abc");
		Account account2 = new Account("John", "abc");
		Account account3 = new Account("Justin", "abc");

		accounts.add(account);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + "DOING WORK");
	}
	
	public void doWork() {
		System.out.println("doing work in do work");
	}

	public String getName() {
		System.out.println("in get name");
		return name;
	}

	public void setName(String name) {
		System.out.println("in set name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("in get service code");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("in set service code");
		this.serviceCode = serviceCode;
	}
	
}
