/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class myInputMismatchException_Float extends Exception {

    public myInputMismatchException_Float(String str) {
        System.out.println("Only input number!");
        boolean check = false;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(str);
            try {
                float i = input.nextFloat();
                if (i <= 10) {
                    check = true;
                } else {
                    System.out.println("The maximum english mark is 10!");
                }
            } catch (InputMismatchException error) {
                System.out.println("Only input number!");
            }
        } while (check == false);
    }
}
