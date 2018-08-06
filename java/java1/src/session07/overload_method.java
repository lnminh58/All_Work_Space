/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

/**
 *
 * @author nguyenducthao
 */
public class overload_method {

    static void add(int a, int b) {
        System.out.println("Sum of a=" + a + "and b=" + b + ": " + (a + b));
    }

    static void add(int a, int b, int c) {
        System.out.println("Sum of a=" + a + ", b=" + b + " and c=" + c + ": " + (a + b + c));
    }

    public static void main(String[] args) {
        add(1, 2);
        add(1, 2, 3);
    }
}
