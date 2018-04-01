/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author nguyenducthao
 */
public class treeset {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("B");
        treeSet.add("C");
//        treeSet.add(1); xay ra exception vi khi chay phuong thuc so sanh
        treeSet.add("E");
        System.out.print("TreeSet: ");
        for (Object i : treeSet) {
            System.out.print(i + " ");
        }
        System.out.println("");
        HashSet hashSet = new HashSet();
        hashSet.add("A");
        hashSet.add("D");
        hashSet.add("B");
        hashSet.add(1);
        hashSet.add("C");
        hashSet.add("E");
        System.out.println("");
        for (Object object : hashSet) {
            System.out.print(object.toString()+" ");
        }
        
    }
}
