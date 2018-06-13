package com.smartdev.spring.basic.hellospring.greetingxml;

public class VietnameseGreet implements DialectGreet {
    @Override
    public String getGreeting() {
        return "Chào mừng bạn đến với Spring Framework";
    }
}
