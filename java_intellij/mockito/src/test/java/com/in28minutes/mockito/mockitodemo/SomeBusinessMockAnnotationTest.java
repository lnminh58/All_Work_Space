package com.in28minutes.mockito.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {

        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] {24,15,3});
         int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24,result);
    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] {15});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(15,result);
    }

    @Test
    public void testFindTheGreatestFromAllData_NoValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] {});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE,result);
    }

}
