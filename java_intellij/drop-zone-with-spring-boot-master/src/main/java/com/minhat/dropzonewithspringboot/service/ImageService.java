package com.minhat.dropzonewithspringboot.service;

import com.minhat.dropzonewithspringboot.entity.Image;

import java.util.List;

public interface ImageService {

    public void saveImage(String path);

    public List<Image> getImages();
}
