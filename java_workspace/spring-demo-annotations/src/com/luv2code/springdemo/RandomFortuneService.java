package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] arrFortune = {
			"Beware of the wolf in sheep 's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	private Random rdm;
	@PostConstruct
	public void startupFortuneService() {
		System.out.println("Some thing must start before main code're runned");
	}
	@PreDestroy
	public void cleanupFortuneService() {
		System.out.println("Some thing must clean before main code're finished");
	}
	@Override
	public String getFortune() {
		rdm= new Random();
		int index = rdm.nextInt(arrFortune.length);
		return arrFortune[index];
	}

}
