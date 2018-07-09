package com.lnminh.maven.spring;


import com.lnminh.maven.spring.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMavenDemoApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-config.xml");
        HelloWorld helloWorld= applicationContext.getBean(HelloWorld.class);
        System.out.println(helloWorld.sayHello());
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
