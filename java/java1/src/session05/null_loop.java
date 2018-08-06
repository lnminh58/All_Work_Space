/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05;

/**
 *
 * @author nguyenducthao
 */
public class null_loop {
    public static void main(String[] args) {
        int i=0,j=10;
        while (++i < --j);
        System.out.println("Midpoint is: " + i);
    }
}
