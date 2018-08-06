/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05.hocfilehandling;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lnmin
 */
public class HocFile {

    static String path = "";
    static File myFile;

    static void taoThuMuc() {
        path = "C:\\Users\\lnmin\\Desktop\\Minh";
        myFile = new File(path);
        myFile.mkdir();
    }

    static void kiemTraThuMuc() {
        path = "C:\\Users\\lnmin\\Desktop\\Minh";
        myFile = new File(path);
        if (myFile.exists()) {
            JOptionPane.showMessageDialog(null, "Ton Tai");
        } else {
            JOptionPane.showMessageDialog(null, "Khong Ton Tai");
        }
    }

    static void taoFile() {
        try {
            path = "C:\\Users\\lnmin\\Desktop\\Minh/test.txt";
            myFile = new File(path);
            myFile.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "lỗi");
        }

    }

    public static void main(String[] args) {
        taoThuMuc();
//        kiemTraThuMuc();
        taoFile();

    }
}
