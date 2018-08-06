/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import model.PhongBan;

/**
 *
 * @author lnmin
 */
public class FileFactory {

    private static final String PATH = "D:\\workspace\\java\\QuanLyNhanVienBai20\\file.txt";

    public static String luuFile(Vector<PhongBan> listPhongBan) {
        try {

            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listPhongBan);
            oos.close();
            fos.close();
            return "Lưu Thành Công";
        } catch (Exception e) {
            return "Lưu Thất bại";
        }
    }

    public static Vector<PhongBan> loadFile() {
        Vector<PhongBan> listPhongBan = new Vector<>();
        try {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            listPhongBan = (Vector<PhongBan>) data;
            ois.close();
            fis.close();

        } catch (Exception e) {
        }
        return listPhongBan;

    }
}
