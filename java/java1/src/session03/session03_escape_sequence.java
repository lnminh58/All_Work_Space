/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author ndt
 */
public class session03_escape_sequence {
    
    
    public static void main(String[] args) {
        String chuoi1="Dat nuoc";
        String chuoi2="Viet Nam";
        System.out.println("Noi dung cua chuoi1 khi dung \b: "+chuoi1+"\b");
        System.out.println("Noi dung cua chuoi1 va chuoi 2 khi dung \\n: "+chuoi1+"\n"+chuoi2);
        System.out.println("Noi dung cua chuoi1 va chuoi 2 khi dung \\r: ");
        System.out.println(chuoi1+"\r"+chuoi2);
        
    }
}
