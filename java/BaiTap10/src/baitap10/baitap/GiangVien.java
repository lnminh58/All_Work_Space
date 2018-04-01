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
public class GiangVien extends Nguoi{
    private int tienLuongHangThang;

    public GiangVien() {
    }

    public GiangVien(int tienLuongHangThang, String hoTen, int namSinh, int maThe) {
        super(hoTen, namSinh, maThe);
        this.tienLuongHangThang = tienLuongHangThang;
    }

    public int getTienLuongHangThang() {
        return tienLuongHangThang;
    }

    public void setTienLuongHangThang(int tienLuongHangThang) {
        this.tienLuongHangThang = tienLuongHangThang;
    }

    @Override
    public String toString() {
        
        return super.toString()+"\nGiangVien{" + "tienLuongHangThang=" + tienLuongHangThang + '}';
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin(); //To change body of generated methods, choose Tools | Templates.
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tiền lương hàng tháng");
        this.tienLuongHangThang = input.nextInt();
     }
    
}
