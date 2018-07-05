package com.minhat.dropzonewithspringboot.controller;

import com.minhat.dropzonewithspringboot.entity.Image;
import com.minhat.dropzonewithspringboot.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
//@RequestMapping("/v1/api")
public class UploadController {

    public final static Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ImageService imageService;

    private static String UPLOADED_FOLDER = "src/main/resources/image/";

    @RequestMapping("/")
    private String upLoadPage() {
        LOGGER.info("");
        return "upload";
    }

    @PostMapping("handleUpload")
    private String handleUpload(@RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.info("handle upload");
        if(file.isEmpty()) {
            throw new FileNotFoundException();
        }
        LOGGER.info(file.getOriginalFilename());
        byte[] imageData = file.getBytes();
        String pathFile = UPLOADED_FOLDER + file.getOriginalFilename();
        Path path = Paths.get(pathFile);
        Files.write(path, imageData);
        String pathSave = "/upload/" +file.getOriginalFilename();
        imageService.saveImage(pathSave);
        return "upload";
    }

    @GetMapping("/showList")
    private ModelAndView showListImage(ModelAndView model) {
        List<Image> images = imageService.getImages();
        model.addObject("images", images);
        model.setViewName("showList");
        LOGGER.info("go to show image page");
        return model;
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().build();
    }
}
