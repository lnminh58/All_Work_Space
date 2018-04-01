/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session12;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class try_catch_finally {

    public static void main(String[] args) {
        String str = "Softech.vn";
        int a=1,b=0;
        System.out.println("Chuoi str truoc khi substring: " + str);
        try{
        str=str.substring(5);
        a=a/b;
        }
        catch(StringIndexOutOfBoundsException error){
            System.out.println("Xuat hien loi khi substring dai hon chieu dai cua chuoi");
        }
        catch(ArithmeticException error){
            System.out.println("Khong the chia mot so cho 0");
        }
        catch(Exception error){
            System.out.println("Xuat hien loi: "+error);
        }
        finally{
            System.out.println("Ket thuc try catch");
        }
        System.out.println("Chuoi sau khi subtring: "+str);
    }
}

//try{  
////code ma co the nem exception  
//}catch(Exception_class_Name ref){}
//finally{}
