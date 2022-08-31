package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;

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
