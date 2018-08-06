package com.lnminh.controller;

import com.lnminh.service.BatchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchManager batchManager;

    @RequestMapping("/home")
    public String showBatchs(Model model){
        model.addAttribute("batchs",batchManager.getAllBatchs());
        return "batch-home";
    }
}