/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10_baitap;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
class SinhVien {

    private String hoTen;
    private int namSinh;
    private String maThe;
    private float tienHocPhiConNo;

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setmaThe(String maThe) {
        this.maThe = maThe;
    }

    public void setTienHocPhiConNo(float tienHocPhiConNo) {
        this.tienHocPhiConNo = tienHocPhiConNo;
    }

    public void setInfo(SinhVien sinhvien) {
        boolean kiemTra = false;
        System.out.println("Nhap thong tin sinh vien:");
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten sinh vien: ");
        this.setHoTen(input.nextLine());
        do {
            try {
                kiemTra = true;
                System.out.print("Nhap nam sinh: ");
                input = new Scanner(System.in);
                this.setNamSinh(input.nextInt());
            } catch (Exception loi) {
                System.out.println("Nam sinh phai la mot so nguyen duong.");
                kiemTra = false;
            }
        } while (!kiemTra);
        System.out.print("Nhap ma the: ");
        input = new Scanner(System.in);
        this.setmaThe(input.nextLine());
        do {
            try {
                kiemTra = true;
                System.out.print("Nhap tien hoc phi con no: ");
                input = new Scanner(System.in);
                this.setTienHocPhiConNo(input.nextFloat());
            } catch (Exception loi) {
                System.out.println("Tien hoc phi phai la mot so.");
                kiemTra = false;
            }
        } while (!kiemTra);
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public int getNamSinh() {
        return this.namSinh;
    }

    public String getMaThe() {
        return this.maThe;
    }

    public float getTienHocPhiConNo() {
        return this.tienHocPhiConNo;
    }

    public void getInfo(SinhVien sinhvien) {
        System.out.println("Ho ten: " + this.getHoTen());
        System.out.println("Nam sinh: " + this.getNamSinh());
        System.out.println("Ma the: " + this.getMaThe());
        System.out.printf("Tien hoc phi con no: %,.3f %n", this.getTienHocPhiConNo());
    }
}

class GiangVien extends SinhVien {

    private float tienLuong;

    public void setTienLuong(float tienLuong) {
        this.tienLuong = tienLuong;
    }

    public void setInfo(GiangVien giangvien) {
        boolean kiemTra = false;
        System.out.println("Nhap thong tin giang vien:");
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten giang vien: ");
        this.setHoTen(input.nextLine());
        do {
            try {
                kiemTra = true;
                System.out.print("Nhap nam sinh: ");
                input = new Scanner(System.in);
                this.setNamSinh(input.nextInt());
            } catch (Exception loi) {
                System.out.println("Nam sinh phai la mot so nguyen duong.");
                kiemTra = false;
            }
        } while (!kiemTra);
        System.out.print("Nhap ma the: ");
        input = new Scanner(System.in);
        this.setmaThe(input.nextLine());
        do {
            try {
                kiemTra = true;
                System.out.print("Nhap tien luong hang thang: ");
                input = new Scanner(System.in);
                this.setTienLuong(input.nextFloat());
            } catch (Exception loi) {
                System.out.println("Tien luong hang thang phai la mot so.");
                kiemTra = false;
            }
        } while (!kiemTra);
    }

    public float getTienLuong() {
        return this.tienLuong;
    }

    public void getInfo(GiangVien giangvien) {
        System.out.println("Ho ten: " + this.getHoTen());
        System.out.println("Nam sinh: " + this.getNamSinh());
        System.out.println("Ma the: " + this.getMaThe());
        System.out.printf("Tien luong hang thang: %,.3f %n", this.getTienLuong());
    }
}

class GiamDoc extends SinhVien {

    private float tienTieuHangThang;

    public void setTienTieuHangThang(float tienTieuHangThang) {
        this.tienTieuHangThang = tienTieuHangThang;
    }

    public float getTienTieuHangThang() {
        return this.tienTieuHangThang;
    }
}

public class session10_baitap1 {

    public static void main(String[] args) {
//        SinhVien sinhvien = new SinhVien();
//        sinhvien.setInfo(sinhvien);
//        sinhvien.getInfo(sinhvien);
        GiangVien giangvien = new GiangVien();
        giangvien.setInfo(giangvien);
        giangvien.getInfo(giangvien);
    }
}
