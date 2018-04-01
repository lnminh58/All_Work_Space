/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_and_jdbc;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author nguyenducthao
 */
public class readFileTXT {
    public static String read_FileTXT(String pathFile) throws IOException {
        String contentFileTXT = "";
        java.io.BufferedInputStream bStream = new java.io.BufferedInputStream(
                new FileInputStream(pathFile));

        int ch = 0;
        while ((ch = bStream.read()) != -1) {
            contentFileTXT += (char) ch;
        }
        bStream.close();
        return contentFileTXT;
    }
}
