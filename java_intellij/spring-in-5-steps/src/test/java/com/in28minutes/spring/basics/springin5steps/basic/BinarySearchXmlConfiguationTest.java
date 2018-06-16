package com.in28minutes.spring.basics.springin5steps.basic;

import com.in28minutes.spring.basics.springin5steps
        .SpringIn5StepsBasicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
public class BinarySearchXmlConfiguationTest {


    //    get the value from the context
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasicScenario() {
//        get this bean from the context
        int actualResult = binarySearch.binarySearch(new int[]{}, 5);
//        check if the value is correct
        assertEquals(3,actualResult);


    }

}