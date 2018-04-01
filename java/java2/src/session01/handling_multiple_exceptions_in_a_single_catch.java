/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class handling_multiple_exceptions_in_a_single_catch {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a,b;
        
        try{
            a=1/0;
            b=input.nextInt();
        }
        catch(ArithmeticException|InputMismatchException error){
            System.out.println(""+error);
        }
    }
}
