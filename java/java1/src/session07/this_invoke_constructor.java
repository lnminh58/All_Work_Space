/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session07;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class this_invoke_constructor {
    String hoten;
    int tuoi;
    String diachi;
    public this_invoke_constructor(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        this.hoten = input.nextLine();
    }
    public this_invoke_constructor(int tuoi1, String diachi1){
//        Qui tắc: Lời gọi tới this() phải là lệnh đầu tiên trong Constructor.
        this();
        this.tuoi=tuoi1;
        this.diachi=diachi1;
    }
    public void hienthithongtin(this_invoke_constructor obj){
        System.out.println("Ho ten: " + this.hoten);
        System.out.println("Tuoi: " + this.tuoi);
        System.out.println("Dia chi: " + this.diachi);
    }
    public static void main(String[] args) {
//        this_invoke_constructor obj = new this_invoke_constructor();
//        obj.hienthithongtin(obj);
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tuoi: ");
        int nhapTuoi = input.nextInt();
        input = new Scanner(System.in);
        System.out.print("Nhap dia chi: ");
        String nhapDiaChi = input.nextLine();
        this_invoke_constructor obj1 = new this_invoke_constructor(nhapTuoi, nhapDiaChi);
        obj1.hienthithongtin(obj1);
    }
}
