package com.smartdev.spring.basic.hellospring;

import com.smartdev.spring.basic.hellospring.greeting.SpringReceptionist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(HelloSpringApplication.class, args);

        SpringReceptionist springReceptionist = applicationContext.getBean(SpringReceptionist.class);

        System.out.println(springReceptionist.requestWelcome());

        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
