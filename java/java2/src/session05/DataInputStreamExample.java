/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenducthao
 */
public class DataInputStreamExample {

    public static void main(String[] args) {

        int i;
        double d;
        boolean b;
        char ch;
        String str;

        try (DataInputStream dataInput = new DataInputStream(
                new FileInputStream("C:\\Users\\lnmin\\Desktop\\Minh\\test.txt"))) {
            i = dataInput.readInt();
            System.out.println("Reading Int: " + i);
            d = dataInput.readDouble();
            System.out.println("Reading Double: " + d);
            b = dataInput.readBoolean();
            System.out.println("Reading Boolean: " + b);
            d = dataInput.readDouble();
            System.out.println("Reading Double: " + d);
            ch = dataInput.readChar();
            System.out.println("Reading char: " + ch);
            str = dataInput.readUTF();
            System.out.println("Reading String: " + str);
        } catch (IOException ex) {
            Logger.getLogger(DataInputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*
DataInputStream được sử dụng trong ngữ cảnh của DataOutputStream 
và có thể được sử dụng để đọc các dữ liệu gốc (nguyên thủy) trong Java
 */
