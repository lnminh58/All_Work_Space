/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1.session5;

import java.util.Scanner;

/**
 *
 * @author lnminh
 */
public class HocSo {

//    
//    static {
//        System.out.println("chay dau tien");
//    }
    public static int nhapSoNguyen() {
        Scanner nhapSo = new Scanner(System.in);
        return nhapSo.nextInt();

    }

    public static void chiaHetCho3() {
        System.out.println("Nhap vao so nguyen: ");
        int n = nhapSoNguyen();
        System.out.println("Cac so chia het cho 3: ");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                System.out.print(" " + i);
            }
        }
    }

    public static void inSoChiaHetCho5() {
        System.out.println("Nhap so luong");
        int n = nhapSoNguyen();
        int dem = 0;
        System.out.println("Nhung so chia het cho 5");
        for (int i = 0;; i++) {
            if (i % 5 == 0) {
                System.out.print(" " + i);
                dem++;
            }
            if (dem == n) {
                return;
            }
        }
    }
    
    public static boolean laSoLe(int n){
        return n%2!=0;
    }
    
    public static void nhapSoLe(){
        System.out.println("Nhap Vao So Le: ");
        int soDaNhap = nhapSoNguyen();
        if(laSoLe(soDaNhap)){
            return;
        }
        System.out.println("Nhap sai,moi nhap lai");
        nhapSoLe();
    }
    public static void main(String[] args) {
//        HocSo doituong = new HocSo();
//        doituong.chiaHetCho3(doituong.nhapSoNguyen());   // neu cac phuong thuc non-static
     nhapSoLe();
    }
}
