package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class ARCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 5 rounds with VR glass";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
