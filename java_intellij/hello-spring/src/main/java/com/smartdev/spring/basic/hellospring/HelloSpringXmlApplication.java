package com.smartdev.spring.basic.hellospring;

import com.smartdev.spring.basic.hellospring.greeting.SpringReceptionist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpringXmlApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringReceptionist springReceptionist = applicationContext.getBean(SpringReceptionist.class);
        SpringReceptionist springReceptionist1 = applicationContext.getBean(SpringReceptionist.class);

        System.out.println( "By xml config");
        System.out.println(springReceptionist.requestWelcome());
        System.out.println(springReceptionist.getContact());


        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
