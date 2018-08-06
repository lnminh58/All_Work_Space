package com.smartdev.spring.basic.hellospring.greetingxml;

public class EnglishGreet implements DialectGreet {

    @Override
    public String getGreeting() {
        return "Welcome to Spring Framework";
    }
}
