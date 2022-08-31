package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + "DOING WORK");
	}
	
	public void doWork() {
		System.out.println("doing work in do work");
	}
}
