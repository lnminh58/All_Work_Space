/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author lnmin
 */
public class FindCustomer {
    public static void findByName(ArrayList<Customer> listCustomer,String name){
        for (Customer customer : listCustomer) {
            if(customer.getName().equalsIgnoreCase(name)){
                System.out.println(customer);
            }
        }
    }
    public static void findByPhoneNumber(ArrayList<Customer> listCustomer,String phoneNumber){
        for (Customer customer : listCustomer) {
            if(customer.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                System.out.println(customer);   
            }
        }
    }
    
}
