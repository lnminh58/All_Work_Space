/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author lnmin
 */
public class KhachHang implements Serializable{
    private String ma;
    private String ten;
    private String soDienThoai;
    private String email;
    private NhomKhachHang nhom;

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String soDienThoai, String email) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhomKhachHang getNhom() {
        return nhom;
    }

    public void setNhom(NhomKhachHang nhom) {
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return ten ;
    }
    
}
