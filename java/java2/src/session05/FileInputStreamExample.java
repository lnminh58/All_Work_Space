/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author nguyenducthao
 */
public class FileInputStreamExample {
    public static void main(String[] args) {
        FileInputStream fip = null;
        File file;
        String content = "This is the text content";
  
        try {
  
            file = new File("C:\\Users\\lnmin\\Desktop\\Minh\\test.txt");
            fip = new FileInputStream(file);
  
            // get the content in bytes
            int ch = 0;
            while ((ch = fip.read()) != -1) {
                System.out.print((char) ch);
            }
            fip.close();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fip != null) {
                    fip.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
