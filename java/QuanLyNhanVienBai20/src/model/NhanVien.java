/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lnmin
 */
public class NhanVien implements Serializable{
    private String maNhanVien;
    private String tenNhanVien;
    private Date ngayVaoLamVien;
    private Date namSinh;
    private PhongBan phong;

    public NhanVien() {
    }
    
    
    public NhanVien(String maNhanVien, String tenNhanVien, Date ngayVaoLamVien, Date namSinh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngayVaoLamVien = ngayVaoLamVien;
        this.namSinh = namSinh;
    }
    
    
    public String getMaNhanVien() {
        return maNhanVien;
    }
    
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgayVaoLamVien() {
        return ngayVaoLamVien;
    }

    public void setNgayVaoLamVien(Date ngayVaoLamVien) {
        this.ngayVaoLamVien = ngayVaoLamVien;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public PhongBan getPhong() {
        return phong;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }

    @Override
    public String toString() {
            return  this.maNhanVien+"     "+this.tenNhanVien ;
    }
    
    
    
}
