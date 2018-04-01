package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HappyFortuneService implements FortuneService{
	private List<String> listFortune;
	private Random myRand;
	@Override
	public String getForture() {
		listFortune = new ArrayList<>();
		listFortune.add("Beware of the wolf in sheep's clothing");
		listFortune.add("Diligence is the mother of good luck");
		listFortune.add("The journey is the reward");
		myRand= new Random();
		int index = myRand.nextInt(listFortune.size());
		
		// TODO Auto-generated method stub
		return listFortune.get(index);
	}

}
