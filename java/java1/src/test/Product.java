/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author nguyenducthao
 */
public class Product implements Comparable<Product> {

    private int ID;
    private String name;

    public Product() {
    }

    public Product(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", name=" + name + '}';
    }

//    @Override
//    public int compare(Product product1, Product product2) {
//        int ID1,ID2;
//        ID1=product1.getID();
//        ID2=product2.getID();
//        if(ID1>ID2){
//            return 1;
//        }
//        else{
//            if(ID1==ID2){
//                return 0;
//            }
//            else{
//                return -1;
//            }
//        }
//    }
    @Override
    public int compareTo(Product product) {
        if (this.getID() > product.getID()) {
            return 1;
        } else {
            if (this.getID() == product.getID()) {
                if (this.getName().compareTo(product.getName()) > 0) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> arrList = new ArrayList<>();
        Product product = new Product(1, "a");
        arrList.add(product);
        product = new Product(3, "c");
        arrList.add(product);
        product = new Product(2, "b");
        arrList.add(product);
        product = new Product(1, "d");
        arrList.add(product);
        product = new Product(1, "b");
        arrList.add(product);
        product = new Product(1, "d1");
        arrList.add(product);
        Collections.sort(arrList);
        for (Product product1 : arrList) {
            System.out.println(product1);
        }
    }
}
