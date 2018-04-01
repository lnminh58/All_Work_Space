package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SportConfig.class);

		// get the bean from bing container
		SwimCoach theCoach = (SwimCoach) context.getBean("swimCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
		// Call our new swim coach methods
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
