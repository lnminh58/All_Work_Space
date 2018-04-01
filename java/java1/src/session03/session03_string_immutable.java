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
public class session03_string_immutable {
    public static void main(String[] args) {
        String str="This is a string";
        System.out.println("Gia tri cua bien str: "+str);
        str.concat(" This is a new string1");
        System.out.println("Gia tri cua bien str1: "+str);
        str=str.concat(" This is a new string2");
        System.out.println("Gia tri cua bien str2: "+str);
        session03_string_immutable var1=null;
        long abc;
        abc=1234_9876_5012_5454L;
        System.out.println("Gia tri cua bien abc: "+abc);
    }
    
    
    
}
