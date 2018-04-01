package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run hardly on the grass 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
