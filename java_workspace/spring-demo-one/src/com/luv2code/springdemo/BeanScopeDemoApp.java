package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// Retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach",Coach.class);

		Coach alphaCoach = context.getBean("myCoach",Coach.class);

		if(theCoach == alphaCoach) {
			System.out.println("same object");
		}else {
			System.out.println("Different object");
		}
		
		context.close();
	}

}
