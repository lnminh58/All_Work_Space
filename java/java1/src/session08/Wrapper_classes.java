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
public class Wrapper_classes {

    public static void main(String[] args) {
        // Autoboxing
        // Chuyen doi int thanh Integer
        int a = 10;
        Integer b = Integer.valueOf(a);//chuyển đổi int thành Integer
        Integer c = a;//Day la autoboxing, bay gio compiler se viet la Integer.valueOf(a)
        System.out.println(a + " " + b + " " + c);
        System.out.println(Integer.TYPE);
        
        // Unboxing
        // Chuyen doi Integer thanh int
        Integer a1 = new Integer(3);
        int b1 = a1.intValue();//Chuyen doi Integer thanh int
        int c1 = a1;//Day la unboxing, bay gio compiler se viet la a.intValue()
        System.out.println(a1 + " " + b1 + " " + c1);
    }
}
