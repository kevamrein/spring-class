package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addThisAccount() {
		System.out.println(getClass() + " DOING THIS WORK");
	}
}
