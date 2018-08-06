/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session04;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class ifStatement {

    public static void main(String[] args) {
        System.out.println("Chương trình kiểm tra một số là số chẵn hay số lẻ (sử dụng if đơn).");
        System.out.print("Nhập vào một số nguyên bất kỳ: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if ((i % 2) == 0) {
            System.out.println("Số vừa nhập vào là: " + i + ". Đó là số chẵn!");
        }
    }
}
