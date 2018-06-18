package com.lnminh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

    // need a controller method to show the initial HTML form

    @RequestMapping("/showForm")
    public String showForm() {
        return "form";
    }

    // need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "form-respond";
    }

    @RequestMapping("/processFormAddDataToModel")
    public String processFormAddDataToModel(HttpServletRequest request, Model model) {
// read the request parameter
        String username = request.getParameter("username");
// convert data
        String upperUsername = username.toUpperCase();
// add data to model
        model.addAttribute("upperUsername", upperUsername);

        return "form-respond";
    }

    @RequestMapping("/processFormAddDataToModel_RequestParam")
    public String processFormAddDataToModel_RequestParam (@RequestParam("username") String username, Model model){
        String upperUsername = username.toUpperCase();

        model.addAttribute("upperUsername",upperUsername);
        return "form-respond";
    }
}






