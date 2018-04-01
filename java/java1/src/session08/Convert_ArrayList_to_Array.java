/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.util.ArrayList;

/**
 *
 * @author nguyenducthao
 */
public class Convert_ArrayList_to_Array {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("AAAAAAAAAAAA");
        list.add("BBBBBBBBBBBB");
        list.add("CCCCCCCCCCCC");
        list.add("DDDDDDDDDDDD");

        String[] arrStr = list.toArray(new String[list.size()]);
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i] + " ");
        }
    }
}
