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
public class ifelseifStatement {

    public static void main(String[] args) {
        System.out.println("Chương trình kiểm tra một số nguyên có bằng 1 hoặc 2 hay không (sử dụng if else if).");
        System.out.print("Nhập vào một số nguyên bất kỳ: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if (i == 1) {
            System.out.println("Số vừa nhập vào là: " + i + ". Đó là số 1!");
        } else {
            if (i == 2) {
                System.out.println("Số vừa nhập vào là: " + i + ". Đó là số 2!");
            } else {
                System.out.println("Số vừa nhập vào là: " + i + ". Đó không phải là số 1 hoặc 2!");
            }
        }
    }
}
