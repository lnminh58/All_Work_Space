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
public class NhomKhachHang implements Serializable{
    private String maNhom;
    private String tenNhom;
    private Vector<KhachHang> dsKhachHang;
    
    public void themKhachHang(KhachHang khachHang){
        this.dsKhachHang.add(khachHang);
        khachHang.setNhom(this);
    }
    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public Vector<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(Vector<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
        
    }

    public NhomKhachHang(String maNhom, String tenNhom) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
        this.dsKhachHang = new Vector<>();
    }

    public NhomKhachHang() {
        this.dsKhachHang = new Vector<>();
    }

    @Override
    public String toString() {
        return this.tenNhom ;
    }

    
    
    
}
