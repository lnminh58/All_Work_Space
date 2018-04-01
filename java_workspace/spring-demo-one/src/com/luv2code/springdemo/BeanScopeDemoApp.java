package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) {
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanScope-applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach==alphaCoach);
		System.out.println(result);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		context.close();
	}
}
 