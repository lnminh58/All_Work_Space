package com.smartdev.spring.basic.hellospring.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpringReceptionist {
    @Autowired
    @Qualifier(value = "englishGreet")
    DialectGreet dialectGreet;

    public String requestWelcome(){
        return  dialectGreet.getGreeting();
    }

}
