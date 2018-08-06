package com.smartdev.spring.basic.hellospring.greeting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EnglishGreet implements DialectGreet {

    @Override
    public String getGreeting() {
        return "Welcome to Spring Framework";
    }
}
