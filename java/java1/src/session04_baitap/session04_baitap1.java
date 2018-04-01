/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//1. Viết chương trình để nhập một số nguyên bất kỳ từ bàn phím
//và in kết quả ra màn hình để nói cho người dùng biết số đó là lớn hay nhỏ hơn 100.
package session04_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session04_baitap1 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap mot so nguyen bat ky: ");
        int songuyen = nhap.nextInt();
        if(songuyen<100){
            System.out.println("So nguyen vua nhap nho hon 100");
        }
        else{
            if(songuyen==100){
                System.out.println("So nguyen vua nhap bang 100");
            }
            else
                System.out.println("So nguyen vua nhap lon hon 100");
        }
    }
}
