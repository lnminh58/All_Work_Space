package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	// define a private field for the dependency
	private FortuneService fortuneService;
	
//	define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 on Batting pratice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
