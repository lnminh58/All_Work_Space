package com.in28minutes.spring.basics.springin5steps.cdi;

import com.in28minutes.spring.basics.springin5steps
        .SpringIn5StepsCdiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {



    @Mock
    SomeCdiDAO daoMock;

    @InjectMocks
    SomeCdiBusiness business;


    @Test
    public  void testBasicScenario(){
        when(daoMock.getData()).thenReturn(new int[] {100,10,200});
        assertEquals(200,business.findGreatest());
    }

    @Test
    public  void testBasicScenario_NoElement(){
        when(daoMock.getData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE,business.findGreatest());
    }
}