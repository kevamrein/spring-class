package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyGolfApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myGolfCoach", Coach.class);
		System.out.println("Fortune 1: " + coach.getDailyFortune());
		System.out.println("Fortune 2: " + coach.getDailyFortune());
		System.out.println("Fortune 3: " + coach.getDailyFortune());
		
		context.close();
	}

}
