package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.xml.XmlPersonDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
public class SpringIn5StepsXMLContextApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//        BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsXmlContextApplication.class);
        XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
        System.out.println(xmlPersonDAO);
       applicationContext.close();
    }
}
