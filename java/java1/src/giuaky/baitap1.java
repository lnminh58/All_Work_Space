/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giuaky;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
class NhanVien{
    String ten;
    int tuoi;
    String diachi;
    double tienluong;
    int tongsogiolam;

    public NhanVien() {

    }

    public NhanVien(String ten, int tuoi, String diachi, float tienluong, int tongsogiolam) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
        this.tienluong = tienluong;
        this.tongsogiolam = tongsogiolam;
    }

    public void inputInfo(NhanVien nhanvien) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        this.ten = input.nextLine();
        System.out.print("Nhap tuoi: ");
        this.tuoi = input.nextInt();
        System.out.print("Nhap dia chi: ");
        input = new Scanner(System.in);
        this.diachi = input.nextLine();
        System.out.print("Nhap tien luong: ");
        this.tienluong = input.nextFloat();
        System.out.print("Nhap tong so gio lam: ");
        this.tongsogiolam = input.nextInt();
    }

    public void printInfo(NhanVien nhanvien) {
        System.out.println("Ho ten: " + this.ten);;
        System.out.println("Tuoi: " + this.tuoi);
        System.out.println("Dia chi: " + this.diachi);
        System.out.println("Tien luong: " + this.tienluong);
        System.out.println("Tong so gio lam: " + this.tongsogiolam);
    }

    public double tinhThuong(NhanVien nhanvien) {
        double soTienThuong = 0;
        if (this.tongsogiolam < 100) {
            soTienThuong = 0;
        } else if ((this.tongsogiolam >= 100) && (this.tongsogiolam < 200)) {
            soTienThuong = this.tienluong * 0.1;
        } else if (this.tongsogiolam >= 200) {
            soTienThuong = this.tienluong * 0.2;
        }
        return soTienThuong;
    }
}
public class baitap1 {
    public static void main(String[] args) {
        NhanVien nhanvien = new NhanVien();
        nhanvien.inputInfo(nhanvien);
        nhanvien.printInfo(nhanvien);
        System.out.println("So tien thuong: " + nhanvien.tinhThuong(nhanvien));
    }
}
