package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public BaseballCoach() {
		
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getForture();
	}
}
