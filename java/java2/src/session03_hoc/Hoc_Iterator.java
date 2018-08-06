/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03_hoc;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author lnmin
 */
public class Hoc_Iterator {
    public static void main(String[] args) {
        ArrayList<String> listTen=new ArrayList<>();
        
        listTen.add("Minh");
        listTen.add("John");
        listTen.add("Andy");
        
        ArrayList<String> listTen1=new ArrayList<>(listTen.subList(0,listTen.size()));
        listTen.add("Michael");
        listTen.add("Traytor");
        listTen.add("Tery");
        ListIterator<String> li = listTen.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println("======================");
        
        while(li.hasPrevious()){
            if(li.previous().equalsIgnoreCase("Andy")){
                li.remove();
            }
        }
        for (String string : listTen) {
            System.out.println(string);
        }
        System.out.println("======================");
        for (String string : listTen1) {
            System.out.println(string);
        }
    }
}
