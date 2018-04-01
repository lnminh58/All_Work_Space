/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import model.NhomKhachHang;

/**
 *
 * @author lnmin
 */
public class FileFactory {
    public static String luuFile(Vector<NhomKhachHang> dsNhomKhachHang,String path) {
        try {

            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsNhomKhachHang);
            oos.close();
            fos.close();
            return "Lưu Thành Công";
        } catch (Exception e) {
            return "Lưu Thất bại";
        }
    }

    public static Vector<NhomKhachHang> loadFile(String path) throws IOException {
        Vector<NhomKhachHang> dsNhomKhachHang = new Vector<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            dsNhomKhachHang = (Vector<NhomKhachHang>) data;
            ois.close();
            fis.close();

        } catch (Exception e) {
            throw new IOException();
        }
        return dsNhomKhachHang;

    }
}
