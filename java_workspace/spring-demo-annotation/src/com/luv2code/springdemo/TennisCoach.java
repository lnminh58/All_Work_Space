package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	//
	// @Autowired public TennisCoach(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	// }
	//

	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside defaut constructor");
	}

	// @Autowired
	// public void setFortuneService(FortuneService fortuneService) {
	// System.out.println(">> Tennis Coach: inside setFortuneService() method ");
	// this.fortuneService = fortuneService;
	// }

	// @Autowired
	// public void doSomeCrazyStuff(FortuneService fortuneService) {
	// System.out.println(">> Tennis Coach: inside doSomeCrazyStuff() method ");
	// this.fortuneService = fortuneService;
	// }

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	// define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff() method");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff() method");
	}

}
