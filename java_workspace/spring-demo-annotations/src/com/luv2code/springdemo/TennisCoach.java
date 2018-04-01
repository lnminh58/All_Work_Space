package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Component("thatSillyCoach")  //with explicitly specify
//@Scope("prototype")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
/*	public FortuneService getFortuneService() {
		return fortuneService;
	}
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService method");
		this.fortuneService = fortuneService;
	}
	*/
	@PostConstruct
	public void startupMethod() {
		System.out.println("Do some thing start up ");
	}
	@PreDestroy
	public void cleanupMethod() {
		System.out.println("Do some thing clean up ");
	}
	
	@Override
	public String getDailyWorkout() {
	
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
