/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session06_baitap;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class Student {

    String Name;
    int Age;
    float English;
    float Computer;
    float Math;
    float marksAverage;

    public Student(String hoTen, int tuoi, float anhVan, float tinHoc, float toan) {
        Name = hoTen;
        Age = tuoi;
        English = anhVan;
        Computer = tinHoc;
        Math = toan;
    }

    public void hienThiThongTinSInhVien() {
        System.out.println("\tName: " + Name);
        System.out.println("\tAge: " + Age);
        System.out.println("\tMarks:");
        System.out.println("\t\tEnglish: " + English);
        System.out.println("\t\tComputer: " + Computer);
        System.out.println("\t\tMath: " + Math);
    }

    public void marksAverage(String ten, float anhvan, float tinhoc, float toan) {
        float Average=(anhvan+tinhoc+toan)/3;
        System.out.println("\tName: " + ten);
        System.out.println("\tMarks Average: " + Average);
    }

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhap thong tin sinh vien thu 1:");
        System.out.print("Ho ten: ");
        String hoTen = nhap.nextLine();
        System.out.print("Tuoi: ");
        int tuoi = nhap.nextInt();
        System.out.print("Diem anh van: ");
        float diemAnhVan = nhap.nextFloat();
        System.out.print("Diem tin hoc: ");
        float diemTinHoc = nhap.nextFloat();
        System.out.print("Diem toan: ");
        float diemToan = nhap.nextFloat();
        Student sinhvien1 = new Student(hoTen, tuoi, diemAnhVan, diemTinHoc, diemToan);
//        nhap = new Scanner(System.in);
//        System.out.println("Nhap thong tin sinh vien thu 2:");
//        System.out.print("Ho ten: ");
//        hoTen = nhap.nextLine();
//        System.out.print("Tuoi: ");
//        tuoi = nhap.nextInt();
//        System.out.print("Diem anh van: ");
//        diemAnhVan = nhap.nextFloat();
//        System.out.print("Diem tin hoc: ");
//        diemTinHoc = nhap.nextFloat();
//        System.out.print("Diem toan: ");
//        diemToan = nhap.nextFloat();
//        Student sinhvien2 = new Student(hoTen, tuoi, diemAnhVan, diemTinHoc, diemToan);
//        nhap = new Scanner(System.in);
//        System.out.println("Nhap thong tin sinh vien thu 3:");
//        System.out.print("Ho ten: ");
//        hoTen = nhap.nextLine();
//        System.out.print("Tuoi: ");
//        tuoi = nhap.nextInt();
//        System.out.print("Diem anh van: ");
//        diemAnhVan = nhap.nextFloat();
//        System.out.print("Diem tin hoc: ");
//        diemTinHoc = nhap.nextFloat();
//        System.out.print("Diem toan: ");
//        diemToan = nhap.nextFloat();
//        Student sinhvien3 = new Student(hoTen, tuoi, diemAnhVan, diemTinHoc, diemToan);
//        System.out.println("Student 1:");
//        sinhvien1.hienThiThongTinSInhVien();
//        System.out.println("Student 2:");
//        sinhvien2.hienThiThongTinSInhVien();
//        System.out.println("Student 3:");
//        sinhvien3.hienThiThongTinSInhVien();
//        tinh diem trung binh
//        sinhvien1.marksAverage = (sinhvien1.Computer + sinhvien1.English + sinhvien1.Math) / 3;
        System.out.println("Marks Average:");
        System.out.println("Student 1:");
        sinhvien1.marksAverage(sinhvien1.Name,sinhvien1.English, sinhvien1.Computer, sinhvien1.Math);
//        System.out.println("Student 2:");
//        sinhvien1.marksAverage(sinhvien2.Name,sinhvien2.English, sinhvien2.Computer, sinhvien2.Math);
//        System.out.println("Student 3:");
//        sinhvien1.marksAverage(sinhvien3.Name,sinhvien3.English, sinhvien3.Computer, sinhvien3.Math);
    }
}
