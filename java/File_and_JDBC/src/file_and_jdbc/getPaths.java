/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_and_jdbc;

import java.io.File;

/**
 *
 * @author nguyenducthao
 */
public class getPaths {

    public static String get_Path() {
        File file = null;
        String filename = "";
        file = new File(filename);
        String pathfile = file.getAbsolutePath();
        return pathfile;
    }
}
