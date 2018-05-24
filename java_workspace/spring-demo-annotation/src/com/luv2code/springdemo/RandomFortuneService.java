package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {


	@Override
	public String getFortune() {
		ArrayList<String> listFortunes = TextFileFactory.readFile("listFortunes.txt");
		return listFortunes.get((new Random()).nextInt(listFortunes.size()));
	}

}
