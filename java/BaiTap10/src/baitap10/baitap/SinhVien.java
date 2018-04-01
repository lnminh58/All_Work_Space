/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap10.baitap;

import java.util.Scanner;

/**
 *
 * @author lnmin
 */
public class SinhVien extends Nguoi{
    private int tienNoHocPhi;

    public SinhVien() {
    }

    public SinhVien(int tienNoHocPhi, String hoTen, int namSinh, int maThe) {
        super(hoTen, namSinh, maThe);
        this.tienNoHocPhi = tienNoHocPhi;
    }

    public int getTienNoHocPhi() {
        return tienNoHocPhi;
    }

    public void setTienNoHocPhi(int tienNoHocPhi) {
        this.tienNoHocPhi = tienNoHocPhi;
    }

    @Override
    public String toString() {
       
        return  super.toString()+"\nSinhVien{" + "tienNoHocPhi=" + tienNoHocPhi + '}';
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tiền nợ học phí:");
        this.tienNoHocPhi=input.nextInt();
    }
    
    
}
