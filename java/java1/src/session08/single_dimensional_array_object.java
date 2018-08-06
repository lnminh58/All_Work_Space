/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session08;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class single_dimensional_array_object {

    String hoTen;

    public single_dimensional_array_object(int sophantu) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten sinh vien thu " + sophantu + ": ");
        this.hoTen = input.nextLine();
    }

    public void hienthithongtin(single_dimensional_array_object obj, int sophantu) {
        System.out.println("Ho ten sinh vien thu " + sophantu + ": " + obj.hoTen);
    }

    public static void main(String[] args) {
        single_dimensional_array_object[] sinhvien = new single_dimensional_array_object[5];
        for (int i = 0; i < sinhvien.length; i++) {
            sinhvien[i] = new single_dimensional_array_object(i + 1);
        }
        for (int i = 0; i < sinhvien.length; i++) {
            sinhvien[i].hienthithongtin(sinhvien[i], i + 1);
        }
    }
}
