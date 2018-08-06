/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Bài tập 2:
//
//Tạo lớp Student, lưu trữ các thông tin một sinh viên:
//
//- Mã sinh viên: chứa 8 kí tự
//
//- Điểm trung bình: từ 0.0 – 10.0
//
//- Tuổi: Phải lớn hơn hoặc bằng 18
//
//- Lớp: Phải bắt đầu bởi kí tự ‘A’ hoặc kí tự ‘C’
//
//Constructor không tham số. Constructor đầy đủ tham số. Các hàm get/set
//
//a. phương thức inputInfo(), nhập thông tin Student từ bàn phím
//
//b. phương thức showInfo(), hiển thị tất cả thông tin Student
//
//c. Viết phương thức xét xem Student có được học bổng không? Điểm trung bình trên 8.0 là được học bổng
//package giuaky;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
class Student {

    String maSinhVien;
    float diemTrungBinh;
    int tuoi;
    String lop;

    public Student() {

    }

    public Student(String maSinhVien, float diemTrungBinh, int tuoi, String lop) {
        this.maSinhVien = maSinhVien;
        this.diemTrungBinh = diemTrungBinh;
        this.tuoi = tuoi;
        this.lop = lop;
    }

    public void inputInfo(Student student) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhap ma sinh vien (8 ki tu): ");
            input = new Scanner(System.in);
            this.maSinhVien = input.nextLine();
        } while (this.maSinhVien.length() != 8);
        do {
            System.out.print("Nhap diem trung binh (tu 0 den 10): ");
            this.diemTrungBinh = input.nextFloat();
        } while ((this.diemTrungBinh <= 0) || (this.diemTrungBinh >= 10));
        do {
            System.out.print("Nhap tuoi (>=18 tuoi): ");
            this.tuoi = input.nextInt();
        } while (this.tuoi < 18);
        do {
            System.out.print("Nhap lop (bat dau bang ki tu A hoac C):");
            input = new Scanner(System.in);
            this.lop = input.nextLine();
            System.out.println(""+this.lop);
        } while ((this.lop.charAt(0) != 'A') && (this.lop.charAt(0) != 'C'));
    }
}

public class baitap2 {

    public static void main(String[] args) {
        Student student = new Student();
        student.inputInfo(student);
    }

}
