/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */

public class test {

    // DEPARTMENT is a constant
    ArrayList<Integer> listString;
    public test(){
        this.listString=new ArrayList<>();
    }
    public void input(){
        
        for(int i=0;i<5;i++)
            listString.add(i+1);
    }
    public void show(){
        for(int i=0;i<listString.size();i++)
            System.out.println(listString.get(i) +" ");
    }
    public static void main(String args[]) {
        test test1=new test();
        test1.input();
        test1.show();
    
boolean gioitinh;
String str;
str="nguyen duc";
if(str.contains("duc1"))
            System.out.println("abc");
    }
}