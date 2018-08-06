/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//6. Viết chương trình nhập vào tuổi và họ tên của một người . In tuổi và họ tên vừa nhập ra output.
package session03_baitap;

/**
 *
 * @author nguyenducthao
 */
import java.util.*;
public class session03_baitap6 {
    public static void main(String[] args) {
        int tuoi;
        String hoten;
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap tuoi: ");
        tuoi=nhap.nextInt();
        System.out.print("Nhap ho ten: ");
        nhap = new Scanner(System.in);
        hoten=nhap.nextLine();
        System.out.println("Tuoi: "+tuoi);
        System.out.println("Ho ten: "+hoten);
    }
}
