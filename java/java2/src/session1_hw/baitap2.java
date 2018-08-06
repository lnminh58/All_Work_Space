/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session1_hw;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnmin
 */
class ByZeroException extends Exception{

    public ByZeroException() {
        System.out.println("Không thể chia cho 0: ");
    } 
    
}
public class baitap2 {
    static int so1;
    static int so2;
    static void nhap2So() throws InputMismatchException{
            try {
                Scanner ip = new Scanner(System.in);
                System.out.println("Nhập vào số thứ nhẩt");
                so1=ip.nextInt();
                System.out.println("Nhập vào số thứ 2");
                so2=ip.nextInt();
                
            } catch (InputMismatchException e) {
                throw new InputMismatchException();
            }
     
    } 
     static void phepChia() throws ByZeroException{
        try {
            nhap2So();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        if(so2==0){
            throw new ByZeroException();
        }else{
        System.out.println("kết quả: "+(so1/so2));
    }
        
    }
    public static void main(String[] args) {
       
        
        nhap2So();
        
        try {
            phepChia();
        } catch (ByZeroException ex) {
            Logger.getLogger(baitap2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
