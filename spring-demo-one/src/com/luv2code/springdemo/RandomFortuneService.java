package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = new String[] {
			"This is fortune 1",
			"This is fortune 2",
			"This is fortune 3"
	};
	
	private Random random;
	
	@Override
	public String getFortune() {
		random = new Random();
		return fortunes[random.nextInt(fortunes.length)];
	}

}
