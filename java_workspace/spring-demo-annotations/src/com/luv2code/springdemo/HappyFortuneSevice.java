package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneSevice implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
