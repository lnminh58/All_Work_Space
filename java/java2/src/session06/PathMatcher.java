/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session06;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author nguyenducthao
 */
public class PathMatcher {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        java.nio.file.PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:" + "**.{java,class,txt}");
        Path path = Paths.get("D:/session06/session06.txt");
        System.out.println(pathMatcher.matches(path));
    }
}
