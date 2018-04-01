package com.luv2code.springdemo;

public class SoccerCoach implements Coach {

	private static int x;
	
	private FortuneService fortuneService;
	
	public SoccerCoach() {
		x++;
	}

	public int getX() {
		return x;
	}

	

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
