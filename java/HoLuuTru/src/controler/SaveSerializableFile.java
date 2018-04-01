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
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author lnmin
 */
public class SaveSerializableFile {
    public static boolean luuFile(ArrayList<KhachHang> dsKhachHang, String path){
        try {
            FileOutputStream fos= new FileOutputStream(path);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(dsKhachHang);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   public static ArrayList<KhachHang> docFile(String path){
       ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
       try {
           FileInputStream fis= new FileInputStream(path);
           ObjectInputStream ois= new ObjectInputStream(fis);
           Object data= ois.readObject();
           dsKhachHang=(ArrayList<KhachHang>) data;
           ois.close();
           fis.close();
       } catch (Exception e) {
       }
       return dsKhachHang;
   }
}
