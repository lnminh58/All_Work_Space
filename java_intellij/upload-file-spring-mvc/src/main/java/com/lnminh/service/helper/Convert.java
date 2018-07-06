package com.lnminh.service.helper;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Convert {
    public static File convertMultipartFileToFile( MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        file = new File(path+multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }

    public static String convertRootPathToSourcePath (String rootPath){
        String[] split = rootPath.split("\\\\");
        String sourcePath="";
        for (int i=0;i<split.length-2;i++) {
            sourcePath+=split[i]+"\\\\";
        }
        return sourcePath;
    }

}
