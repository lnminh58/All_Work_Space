/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

import jdk.nashorn.internal.ir.BinaryNode;

/**
 *
 * @author nguyenducthao
 */
public class session03_Bitwise {

    public static void main(String args[]) {
        int i = 23, j = 12;
        System.out.println("i= " + i + ", j= " + j);
        System.out.println("i (Binary): " + Integer.toBinaryString(i) + ", j (Binary): " + Integer.toBinaryString(j));
        System.out.println("i & j: " + (i & j));
        System.out.println("i | j: " + (i | j));
        System.out.println("i ^ j: " + (i ^ j));
        i = 43;
        j = 1;
        System.out.println("i= " + i + ", j= " + j);
        System.out.println("i >> j: " + (i >> j));
        System.out.println("i << j: " + (i << j));
        System.out.println(Integer.toBinaryString(27));
        System.out.println(Integer.parseInt("11011", 2));
        System.out.println(23 ^ 12 | 4);
    }
}

/*
Bitwise AND ( & ): 1 & 1 = 1
Bitwise OR ( & ): 0 & 0 = 0
Bitwise XOR ( ^ ):  0 & 0 = 0
                    1 & 1 = 0
*/
