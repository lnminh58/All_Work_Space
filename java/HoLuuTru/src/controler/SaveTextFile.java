/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author lnmin
 */
public class SaveTextFile {
    public static boolean luuTextFile(ArrayList<KhachHang> dsKhachHang,String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw= new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw= new BufferedWriter(osw);
            for (KhachHang khachHang : dsKhachHang) {
                String line = khachHang.getMa()+";"+khachHang.getTen();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
  
        return false; 
    }
    public static ArrayList<KhachHang> docFile(String path){
        ArrayList<KhachHang> dsKhachHang= new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(path);
            InputStreamReader isr= new InputStreamReader(fis,"UTF-8");
            BufferedReader  br= new BufferedReader(isr);
            String line = br.readLine();
            while(line!=null){
                String []arr = line.split(";");
                if(arr.length==2){
                    KhachHang kh = new KhachHang(Integer.valueOf(arr[0]), arr[1]);
                    dsKhachHang.add(kh);
                }
                line=br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsKhachHang;
    }
}
