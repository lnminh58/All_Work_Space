package com.smartdev.spring.basic.hellospring;

import com.smartdev.spring.basic.hellospring.greeting.SpringReceptionist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.smartdev.spring.basic.hellospring")
@PropertySource("classpath:contact.properties")
public class HelloSpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloSpringApplication.class);

        SpringReceptionist springReceptionist = applicationContext.getBean(SpringReceptionist.class);
        System.out.println("annotation config");
        System.out.println(springReceptionist.requestWelcome());
        System.out.println(springReceptionist.getContact());
        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
