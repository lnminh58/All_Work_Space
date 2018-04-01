/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author nguyenducthao
 */
public class Iterator_and_ListIterator {
    public static void main(String[] args) {
        // Tao mot array list
      ArrayList arrayList1 = new ArrayList();
      // them cac phan tu toi array list
      arrayList1.add("1");
      arrayList1.add("2");
      arrayList1.add("A");
      arrayList1.add("B");
      arrayList1.add("C");
      arrayList1.add("3");
      
      // Su dung iterator de hien thi noi dung cua array list
      System.out.print("Noi dung ban dau cua arrayList1 la: ");
      Iterator iterator1 = arrayList1.iterator();
      while(iterator1.hasNext()) {
         Object element;
         element = iterator1.next();
         System.out.print(element + " ");
      }
      System.out.println();
      // Sua doi cac doi tuong sau khi da duoc lap qua
      ListIterator listIterator1 = arrayList1.listIterator();
      while(listIterator1.hasNext()) {
         Object element = listIterator1.next();
         listIterator1.set(element + "+");
      }
      System.out.print("Noi dung sau khi sua doi cua arrayList1 la: ");
      iterator1 = arrayList1.iterator();
      while(iterator1.hasNext()) {
         Object element = iterator1.next();
         System.out.print(element + " ");
      }
      System.out.println();
      // Bay gio, hien thi list theo chieu nguoc lai
      System.out.print("Hien thi list theo chieu nguoc lai: ");
      while(listIterator1.hasPrevious()) {
         Object element = listIterator1.previous();
         System.out.print(element + " ");
       }
       System.out.println();
        Collections.sort(arrayList1);
        System.out.println("Gia tri arrayList1 sau khi dung Collections.sort la: "+arrayList1);
    }
    
}
