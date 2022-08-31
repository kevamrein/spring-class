package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public boolean addThisAccount() {
		System.out.println(getClass() + " DOING THIS WORK");
		
		return true;
	}
}
