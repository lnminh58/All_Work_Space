package com.in28minutes.mockito.mockito;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Test
    public void testFindTheGreatestFromAllData() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
         int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24,result);

    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{24, 6, 5};
    }
}