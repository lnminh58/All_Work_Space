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
public class Nguoi {
    private String hoTen;
    private int namSinh;
    private int maThe;

    public Nguoi() {
    }
    
    
    public Nguoi(String hoTen, int namSinh, int maThe) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.maThe = maThe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getMathe() {
        return maThe;
    }

    public void setMathe(int maThe) {
        this.maThe = maThe;
    }

    @Override
    public String toString() {
        return "Nguoi{" + "hoTen=" + hoTen + ", namSinh=" + namSinh + ", mathe=" + maThe + '}';
    }
    
    public void nhapThongTin(){
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập thông tin cơ bản: ");
            System.out.println("Nhập tên");
            this.hoTen = input.nextLine();
            System.out.println("Nhập năm sinh:");
            this.namSinh=input.nextInt();
            System.out.println("Nhập mã thẻ:");
            this.maThe=input.nextInt();
        }
    
    
}
