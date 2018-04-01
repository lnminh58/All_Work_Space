/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author lnmin
 */
public class FileFactory {
    public static boolean saveListCustomer(ArrayList<Customer> listCustomer, String path){
         
        try {
            FileOutputStream fos= new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listCustomer);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi ghi dữ liệu: ");
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<Customer> loadListCustomer(String path){
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try {
            FileInputStream fis= new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object data= ois.readObject();
            listCustomer = (ArrayList<Customer>)data;
            ois.close();
            fis.close();
            
        } catch (Exception e) {
            System.out.println("Lỗi đọc dữ liệu");
            e.printStackTrace();
        }
        return listCustomer;
        
    }
}
