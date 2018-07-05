package com.lnminh.controller;

import com.lnminh.service.helper.Convert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {



    @RequestMapping(value = "/upload-form")
    public String showForm(){
        return "upload-form";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile multipartFile, ModelMap modelMap) throws IOException, InvalidFormatException {
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getBytes());
        File file = Convert.convertMultipartFileToFile(multipartFile);
        Workbook workbook = WorkbookFactory.create(file);
        for (Sheet sheet : workbook) {
            System.out.println(sheet.getSheetName());
        }
        modelMap.addAttribute("file", multipartFile);
        return "fileUploadView";
    }

}
