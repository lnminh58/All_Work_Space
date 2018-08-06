/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//1. Nhập vào từ bàn phím 1 số nguyên dương n, sau đó in ra từ 1 đến n có bao nhiêu số chia hết cho 3.
package session05_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session05_bai01 {
    public static void main(String[] args) {
        Scanner nhap=new Scanner(System.in);
        System.out.print("Nhap mot so nguyen duong: ");
        int soNguyenDuong=nhap.nextInt();
        int dem=0;
        for(int i=1;i<=soNguyenDuong;i++){
            if((i%3)==0)
                dem++;
        }
        System.out.println("Tu 1 den "+soNguyenDuong+" co "+dem+" so chia het cho 3");
    }
}
