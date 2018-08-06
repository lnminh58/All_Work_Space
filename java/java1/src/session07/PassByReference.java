/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class PassByReference {
    String hoten;
    public void nhapHoTen(PassByReference obj){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        obj.hoten = input.nextLine();
    }
    public void hienThiHoTen(PassByReference obj){
        System.out.println("Ho ten: " + obj.hoten);
    }
    public static void main(String[] args) {
        PassByReference obj= new PassByReference();
        obj.nhapHoTen(obj);
        obj.hienThiHoTen(obj);
    }
}
