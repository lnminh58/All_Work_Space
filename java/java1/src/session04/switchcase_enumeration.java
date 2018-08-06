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
public class switchcase_enumeration {

    enum seasons {
        xuan, ha, thu, dong
    }

    public static void main(String[] args) {
        System.out.println("Chương trình liệt kê các tháng của một mùa trong năm (sử dụng enumeration trong switch-case).");
        System.out.print("Nhập vào một mùa trong năm: ");
        Scanner input = new Scanner(System.in);
        String season = input.next();
        switch (season) {
            case "xuan":
                System.out.println("Các tháng của mùa xuân là: 1, 2, 3!");
                break;
            case "ha":
                System.out.println("Các tháng của mùa hạ là: 4, 5, 6!");
                break;
            case "thu":
                System.out.println("Các tháng của mùa thu là: 7, 8, 9!");
                break;
            case "dong":
                System.out.println("Các tháng của mùa đông là: 10, 11, 12!");
                break;
            default:
                System.out.println(season + " không phải là một mùa trong năm!");
        }
    }
}
