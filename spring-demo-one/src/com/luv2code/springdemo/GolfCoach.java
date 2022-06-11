package com.luv2code.springdemo;

public class GolfCoach implements Coach {

	private FortuneService fortuneService;
	
	public GolfCoach() {
		
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Hit 60 balls";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
