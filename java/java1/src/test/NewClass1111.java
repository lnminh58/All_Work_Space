/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nguyenducthao
 */
class A{

    public A() {
        System.out.println("Class A");
    }
    
}
class B extends A{
    {
        System.out.println("Class B init");
    }
    public B(){
        System.out.println("Class B");
    }
}
public class NewClass1111 {
    String name;
    int age;
    boolean gender;
    public static void main(String[] args) {
        B b=new B();
    }
}
