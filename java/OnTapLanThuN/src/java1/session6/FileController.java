/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1.session6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class FileController {

    public static void saveFile(Vector<Student> list, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
            System.out.println("lưu thành công");
        }  catch (IOException ex) {
            System.out.println("lỗi lưu dữ liệu");
            System.out.println(ex);
            
        }
    }
    
    public static Vector<Student> loadFile(String path){
        Vector<Student> list = new Vector<>();
        try(FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis)){
            Object data = ois.readObject();
            list=(Vector<Student>) data;
            System.out.println("load file thành công");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("lỗi load dữ liệu");
        }
        return list;
    }
}
