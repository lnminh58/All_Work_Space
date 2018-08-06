/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

/**
 *
 * @author nguyenducthao
 */
public class string {

    public static void main(String[] args) {
        String string1 = new String();
        string1 = "Hello";
        System.out.println("Chieu dai cua chuoi string1 la: " + string1.length());
        int vitri = 4;
        System.out.println("Ky tu tai vi tri " + vitri + " la: " + string1.charAt(vitri));
        string1 = string1.concat(" World!");
        System.out.println("Gia tri chuoi string1 sau khi noi chuoi World! la: " + string1);
        System.out.println("Gia tri khi dung ham compareTo(String str) la: " + string1.compareTo("W"));
        System.out.println("Vi tri cua ky tu e la: " + string1.indexOf("e"));
        System.out.println("Vi tri xuat hien cuoi cung cua ky tu l la: " + string1.lastIndexOf("l"));
        System.out.println("Gia tri chuoi string1 sau khung replace la: " + string1.replace('l', '2'));
        System.out.println("Gia tri cua chuoi substring la: " + string1.substring(0, 5));
        Integer abc=10;
        System.out.println("Gia tri cua bien vitri khi dung ham toString() la: " + abc.toString());
        String chuoi1="  Hello World  ";
        System.out.println("Gia tri cua chuoi1 khi dung ham trim() la: "+chuoi1.trim());
    }

}
