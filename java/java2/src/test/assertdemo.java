/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class assertdemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ur age ");
        int value = scanner.nextInt();
        assert value >= 18:"age<18";
        System.out.println("value is " + value);
        
//        int rate=-1;
//        assert rate<=0 && rate>10:"sadasdqwe";
    }
}
