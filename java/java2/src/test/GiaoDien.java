/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nguyenducthao
 */
public class GiaoDien implements CapNhat {
    private Download download;
 
    /**
     * phuong thuc khoi tao Giao dien, dong thoi dat lang nghe su kien download
     */
    public GiaoDien() {
        download = new Download();
 
        /** dat lang nghe su kien download */
        download.addDownloadListener(this);
    }
 
    private void nhanDownload() {
        download.download();
    }
 
    /**
     * Tu dong duoc goi trong qua trinh download thong qua interface CapNhap
     * @param giaTri
     */
    @Override
    public void capNhatGiaoDien(int giaTri) {
        System.out.println("class giao dien cap nhat duoc: " + giaTri + "%");
    }
 
    public static void main(String[] args) {
        GiaoDien giaoDien = new GiaoDien();
        giaoDien.nhanDownload();
    }
}