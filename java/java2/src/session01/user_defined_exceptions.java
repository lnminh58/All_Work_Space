/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session01;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenducthao
 */
class LoiNhapSoKhong extends Exception {

    public LoiNhapSoKhong() {
        System.out.println("Khong duoc nhap so 0");
        int a;
        do {
            System.out.print("Nhap mot so nguyen khac 0: ");
            Scanner input = new Scanner(System.in);
//            int a;
            a = input.nextInt();
        } while (a == 0);
    }
}

public class user_defined_exceptions {

    public void nhapSoKhacKhong() {
        System.out.print("Nhap mot so nguyen khac 0: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if (a == 0) {
            System.out.println("Khong duoc nhap so khong");
        }
    }

    public void nhapSoKhacKhong1() throws LoiNhapSoKhong {
        System.out.print("Nhap mot so nguyen khac 0: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if (a == 0) {
            throw new LoiNhapSoKhong();
        }
    }

    public static void main(String[] args) {
        user_defined_exceptions test = new user_defined_exceptions();
        try {
            //        test.nhapSoKhacKhong();
            test.nhapSoKhacKhong1();
        } catch (LoiNhapSoKhong ex) {
            Logger.getLogger(user_defined_exceptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
