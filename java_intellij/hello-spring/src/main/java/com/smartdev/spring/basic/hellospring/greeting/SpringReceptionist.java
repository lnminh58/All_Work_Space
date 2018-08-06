package com.smartdev.spring.basic.hellospring.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class SpringReceptionist {

    @Autowired
    @Qualifier(value = "englishGreet")
    private DialectGreet dialectGreet;

    @Value("${contact.user.name}")
    private String name;
    @Value("${contact.user.email}")
    private String email;

    public String getContact(){
        return name +"\t" + email;
    }

    public String requestWelcome(){
        return  dialectGreet.getGreeting();
    }

    @PostConstruct
    public void beforeWelcome(){
        System.out.println("Open the main Door");
    }
    @PreDestroy
    public void afterWelcome(){
        System.out.println("Close the main Door");
    }
}
