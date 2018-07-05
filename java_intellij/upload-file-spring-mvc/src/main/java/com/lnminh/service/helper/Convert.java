package com.lnminh.service.helper;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Convert {
    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File("D://"+multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }
}
