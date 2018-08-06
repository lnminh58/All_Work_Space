package com.lnminh.maven.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    @Autowired
    NameService nameService;

    public String sayHello(){
        return "Hi!I'm "+ nameService.getDefaultName();
    }
}
