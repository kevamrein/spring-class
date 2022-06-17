package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {"Hello", "my", "name", "is", "kevin"};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int randomIndex = random.nextInt(data.length);
		
		return data[randomIndex];
	}

}
