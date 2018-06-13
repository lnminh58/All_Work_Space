package com.smartdev.spring.basic.hellospring.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringReceptionist {
    @Autowired
    @Qualifier(value = "englishGreet")
    DialectGreet dialectGreet;

    public String requestWelcome(){
        return  dialectGreet.getGreeting();
    }

    @PostConstruct
    private void beforeWelcome(){
        System.out.println("Open the main Door");
    }

    @PreDestroy
    private void afterWelcome(){
        System.out.println("Close the main Door");
    }
}
