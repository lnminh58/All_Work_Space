package com.in28minutes.junit;

import org.junit.*;

import static org.junit.Assert.*;

public class MyMathTest {
    MyMath myMath = new MyMath();

    @BeforeClass
    public static  void beforeClassTest(){
        System.out.println("Before class test");
    }

    @AfterClass
    public static  void  afterClassTest(){
        System.out.println("After class test");
    }


    @Before
    public void beforeTest(){
        System.out.println("Before test");
    }

    @After
    public void afterTest(){
        System.out.println("After test");
    }


    @Test
    public void sumWith3Numbers() {
//        fail();
        System.out.println("test sum 3 number");
        int sum = myMath.sum(new int[] {1, 2, 3});

        assertEquals(6,sum);
    }
        @Test
        public void sumWith1Numbers () {
            System.out.println("test sum 1 number");
//        fail();
            int sum = myMath.sum(new int[] { 3});

            assertEquals(3,sum);

     }
}