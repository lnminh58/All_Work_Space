package com.in28minutes.junit;

public class MyMath {
    public MyMath() {
        System.out.println("I 'm Math object");
    }

    public int sum(int[] numbers){
        int sum =0 ;
        for (int i : numbers) {
            sum+=i;
        }
        return sum;
    }
}
