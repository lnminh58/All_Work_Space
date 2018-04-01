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
public class ifnestedStatement {

    public static void main(String[] args) {
        System.out.println("Chương trình kiểm tra một số có phải là số nguyên dương hay không (sử dụng nested-if).");
        System.out.print("Nhập vào một số bất kỳ: ");
        Scanner input = new Scanner(System.in);
        float i = input.nextFloat();
        if (i >= 0) {
            if (((i % 2) == 0) || ((i % 2) == 1)) {
                System.out.println("Số vừa nhập vào là: " + i + ". Đó là số nguyên dương!");
            }
            else{
                System.out.println("Số vừa nhập vào là: " + i + ". Đó không phải là số nguyên dương!");
            }
        } else {
            System.out.println("Số vừa nhập vào là: " + i + ". Đó không phải là số nguyên dương!");
        }
    }
}
