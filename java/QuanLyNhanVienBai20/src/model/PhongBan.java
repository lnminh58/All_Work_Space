/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author lnmin
 */
public class PhongBan implements Serializable {

    private String maPhong;
    private String tenPhong;
    private Vector<NhanVien> listNhanVien;
    
    public void themNhanVien(NhanVien nhanVien){
        this.listNhanVien.add(nhanVien);
        nhanVien.setPhong(this);
    }
    
    public PhongBan() {
        this.listNhanVien = new Vector<>();
    }
    
    public PhongBan(String maPhong, String tenPhong, Vector<NhanVien> listNhanVien) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.listNhanVien = listNhanVien;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Vector<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(Vector<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    @Override
    public String toString() {
        return this.tenPhong;
    }
    
}
