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
public class switchcase {

    public static void main(String[] args) {
        System.out.println("Chương trình kiểm tra một tháng thuộc mùa nào trong năm (sử dụng switch-case).");
        System.out.print("Nhập vào một tháng trong năm: ");
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        switch (month) {
            case 1:
                System.out.println("Tháng " + month + " là mùa xuân!");
                break;
            case 2:
                System.out.println("Tháng " + month + " là mùa xuân!");
                break;
                case 3:
                System.out.println("Tháng "+ month + " là mùa xuân!");
                break;
                case 4:
                System.out.println("Tháng "+ month + " là mùa hạ!");
                break;
                case 5:
                System.out.println("Tháng "+ month + " là mùa hạ!");
                break;
                case 6:
                System.out.println("Tháng "+ month + " là mùa hạ!");
                break;
                case 7:
                System.out.println("Tháng "+ month + " là mùa thu!");
                break;
                case 8:
                System.out.println("Tháng "+ month + " là mùa thu!");
                break;
                case 9:
                System.out.println("Tháng "+ month + " là mùa thu!");
                break;
                case 10:
                System.out.println("Tháng "+ month + " là mùa đông!");
                break;
                case 11:
                System.out.println("Tháng "+ month + " là mùa đông!");
                break;
                case 12:
                System.out.println("Tháng "+ month + " là mùa đông!");
                break;
                default:
                    System.out.println("Tháng "+ month + " không phải là một tháng trong năm!");
        }
    }
}
