package com.lnminh.controller;

import com.lnminh.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favoriteLanguageOptions}")
    private Map<String, String> favoriteLanguageOptions;

    @Value("#{operatingSystemOptions}")
    private Map<String, String> operatingSystemOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favoriteLanguageOptions", favoriteLanguageOptions);
        model.addAttribute("operatingSystemOptions",operatingSystemOptions);
        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println(student.getFirstName()+ " " + student.getLastName());

        return "student-confirmation";
    }
}
