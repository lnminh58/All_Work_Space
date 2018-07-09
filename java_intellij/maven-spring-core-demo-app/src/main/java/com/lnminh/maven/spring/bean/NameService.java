package com.lnminh.maven.spring.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    public String getDefaultName(){
        return "Spring";
    }
}
