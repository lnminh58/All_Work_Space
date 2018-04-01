/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session12_baitap;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class session12_baitap1 {

    public static void main(String[] args) {
        System.out.println("Chuong trinh thuc hien phep chia 2 so nguyen:");
        System.out.print("Nhap so nguyen thu nhat: ");
        Scanner input = new Scanner(System.in);
        int songuyen1 = input.nextInt();
        System.out.print("Nhap so nguyen thu hai: ");
        int songuyen2 = input.nextInt();
        try {
            int ketqua = songuyen1 / songuyen2;
            System.out.println(ketqua);
        } catch (ArithmeticException error) {
            if (error.getMessage().equalsIgnoreCase("/ by zero")) {
                System.out.println("Khong the thuc hien phep chia vi so nguyen thu hai bang 0!");
            }
        }
    }
}
