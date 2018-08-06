/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Vector;

/**
 *
 * @author nguyenducthao
 */
public class NewClass {
    public static void main(String[] args) {
        Vector vColumn=new Vector();
        Vector vData=new Vector();
        
        vColumn.add("No.");
        vColumn.add("Name");
        vColumn.add("Class");
        
        Vector vTemp=new Vector();
        vTemp.add(1);
        vTemp.add("Nguyen Van A");
        vTemp.add("Batch 131");
        
        vData.add(vTemp);
//        System.out.println(vColumn);
//        System.out.println(vData.get(0));
        vTemp=new Vector();
        vTemp=(Vector) vData.elementAt(0);
        System.out.println(vTemp.elementAt(1).getClass());
        String[] abc=(String[]) vColumn.toArray();
        for (String string : abc) {
            System.out.println(string);
        }
    }
}
