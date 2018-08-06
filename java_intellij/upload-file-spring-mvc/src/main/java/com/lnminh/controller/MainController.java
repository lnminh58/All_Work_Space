package com.lnminh.controller;

import com.lnminh.service.helper.Convert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    private final String additionalPath = "src\\main\\resources\\upload\\";

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/upload-form")
    public String showForm(){
        return "upload-form";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile multipartFile, ModelMap modelMap) throws IOException, InvalidFormatException {

        String rootPath= servletContext.getRealPath("");
        String sourcePath= Convert.convertRootPathToSourcePath(rootPath);
        File file = Convert.convertMultipartFileToFile(multipartFile,sourcePath+additionalPath);

        Workbook workbook = WorkbookFactory.create(file);
        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                DataFormatter dataFormatter= new DataFormatter();
                System.out.println();
                for (Cell cell : row) {
                    System.out.print(dataFormatter.formatCellValue(cell)+"\t");
                }
            }
        }

        modelMap.addAttribute("file", multipartFile);
        return "fileUploadView";
    }

}
