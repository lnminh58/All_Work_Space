package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String[] arrService = { 
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};

	
	@Override
	public String getFortune() {
		
		return arrService[new Random().nextInt(arrService.length)];
	}

}
