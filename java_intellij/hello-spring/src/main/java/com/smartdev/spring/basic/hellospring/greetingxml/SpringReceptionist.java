package com.smartdev.spring.basic.hellospring.greetingxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringReceptionist {
    private DialectGreet dialectGreet;



    public SpringReceptionist() {
    }

    public SpringReceptionist(DialectGreet dialectGreet) {
        this.dialectGreet = dialectGreet;
    }

    public DialectGreet getDialectGreet() {
        return dialectGreet;
    }

    public void setDialectGreet(DialectGreet dialectGreet) {
        this.dialectGreet = dialectGreet;
    }

    public String requestWelcome(){
        return  dialectGreet.getGreeting();
    }

    public void beforeWelcome(){
        System.out.println("Open the main Door");
    }
    public void afterWelcome(){
        System.out.println("Close the main Door");
    }


}
