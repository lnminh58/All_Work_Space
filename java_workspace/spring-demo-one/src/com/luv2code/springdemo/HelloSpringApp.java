package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		SoccerCoach theCoach= context.getBean("mySoccerCoach",SoccerCoach.class);
		System.out.println(theCoach.getX());
		SoccerCoach theCoachV2= context.getBean("mySoccerCoach",SoccerCoach.class);

	
		System.out.println(theCoachV2.getX());
		
		
		// close the context
		
		context.close();
	}

}
