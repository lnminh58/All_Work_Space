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
public class dowhile_loop {
    public static void main(String[] args) {
        System.out.print("Hiển thị các số từ 1 đến 10 (sử dụng vòng lặp do while): ");
        int i=1;
        do{
            System.out.print(i+" ");
            i++;
        }while(i<=10);
        System.out.println("");
    }
}
