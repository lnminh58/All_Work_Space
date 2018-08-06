/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.SaveSerializableFile;
import controler.SaveTextFile;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author lnmin
 */
public class QuanLyKhachHang {
    static ArrayList<KhachHang> dsKH=new ArrayList<KhachHang>();
    static void luuFile(){
        dsKH.add(new KhachHang(1, "Minh"));
        dsKH.add(new KhachHang(2, "Thiệm"));
        dsKH.add(new KhachHang(3, "Nhân"));
        dsKH.add(new KhachHang(4, "John"));
        boolean kt= SaveTextFile.luuTextFile(dsKH,"D:\\workspace\\java\\File\\textKhachHang.txt");
        if(kt==true){
            System.out.println("Lưu file thành công");
        }else{
            System.out.println("Lưu file thất bại");
        }
    }
    static void docFile(){
        dsKH= SaveTextFile.docFile("D:\\workspace\\java\\File\\textKhachHang.txt");
        for (KhachHang khachHang : dsKH) {
            System.out.println(khachHang);
        }
    }
    static void luuObjectFile(){
        dsKH.add(new KhachHang(1, "Minh"));
        dsKH.add(new KhachHang(2, "Thiệm"));
        dsKH.add(new KhachHang(3, "Nhân"));
        dsKH.add(new KhachHang(4, "John"));
        boolean kt= SaveSerializableFile.luuFile(dsKH,"D:\\workspace\\java\\File\\textKhachHang2.txt");
        if(kt==true){
            System.out.println("Lưu  object file thành công");
        }else{
            System.out.println("Lưu object file thất bại");
        }
    }
     static void docObjectFile(){
        dsKH= SaveSerializableFile.docFile("D:\\workspace\\java\\File\\textKhachHang2.txt");
        for (KhachHang khachHang : dsKH) {
            System.out.println(khachHang);
        }
    }
    public static void main(String[] args) {
        luuFile();
          docFile();
    // luuObjectFile();
    // docObjectFile();
    }
}
