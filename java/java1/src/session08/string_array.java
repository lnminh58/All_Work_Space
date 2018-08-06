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
public class string_array {
    public static void main(String[] args) {
        String[] string1=new String[10];
        for (int i = 0; i < 10; i++) {
            string1[i]="string1_"+i;
        }
        System.out.println("Gia tri cua mang string1 la: ");
        for (int i = 0; i < string1.length; i++) {
            System.out.println(string1[i]);
        }
    }
}
