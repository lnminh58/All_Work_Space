package com.minhat.dropzonewithspringboot.service.Impl;

import com.minhat.dropzonewithspringboot.entity.Image;
import com.minhat.dropzonewithspringboot.repository.ImageRepository;
import com.minhat.dropzonewithspringboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = Exception.class)
    public void saveImage(String path) {
        Image image = new Image(path);
        imageRepository.save(image);
    }

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }
}
