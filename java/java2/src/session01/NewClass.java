/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01;

/**
 *
 * @author lnmin
 */
public class NewClass {
       
       static void validate(int age){  
         if(age<18)  
          throw new ArithmeticException("not valid");  
         else  
          System.out.println("welcome to vote");  
       }  
       public static void main(String args[]){  
           try {
               validate(13);  
           } catch (Exception e) {
            e.printStackTrace();
           }
          System.out.println("rest of the code...");  
      }
    }  
