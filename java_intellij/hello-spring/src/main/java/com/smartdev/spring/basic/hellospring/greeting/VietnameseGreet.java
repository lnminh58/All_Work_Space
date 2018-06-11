package com.smartdev.spring.basic.hellospring.greeting;

import org.springframework.stereotype.Component;

@Component
public class VietnameseGreet implements DialectGreet {
    @Override
    public String getGreeting() {
        return "Chào mừng bạn đến với Spring Framework";
    }
}
