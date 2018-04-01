/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author lnmin
 */
public class Customer implements Serializable,Comparable<Customer>{
    private static int counter;
    private int idNumber;
    private String name;
    private String phoneNumber;

    public Customer() {
        this.idNumber=++counter;
        try {
            Scanner ip = new Scanner(System.in);
            System.out.print("Nhập tên khách hàng: ");
            this.name = ip.nextLine();
            System.out.print("Nhập số điện thoại khách hàng: ");
            ip = new Scanner(System.in);
            this.phoneNumber=ip.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi nhập");
        }
        
    }

    
    public Customer(String name, String phoneNumber) {
        this.idNumber = ++counter;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



    public static void setCounter(int counter) {
        Customer.counter = counter;
    }

    public int getIdNumber() {
        return idNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\t" + idNumber + "\t" + name + "\t" + phoneNumber;
    }

    @Override
    public int compareTo(Customer t) {
       
            return this.name.compareToIgnoreCase(t.name);
        
    }
    
    
    
}
