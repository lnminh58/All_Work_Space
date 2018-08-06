/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session11_Interface;

/**
 *
 * @author nguyenducthao
 */
public class QuanLyXe {
    public static void main(String[] args) {
        XeToyota xeToyota=new XeToyota();
        XeKia xeKia=new XeKia();
        
        xeToyota.hienthiLoaiXe();
        xeToyota.hienthiNhaSanXuat();
        
        xeKia.hienthiLoaiXe();
        xeKia.hienthiNhaSanXuat();
    }
}
