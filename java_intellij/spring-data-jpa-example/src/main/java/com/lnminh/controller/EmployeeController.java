package com.lnminh.controller;

import com.lnminh.entity.Employee;
import com.lnminh.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView setupForm()
    {
        List<Employee> employees = employeeManager.getAllEmployee();
        for (Employee employ : employees) {
            System.out.println(employ.getFullName());
        }
        //model.addObject("allEmployees",employees);
        ModelAndView model = new ModelAndView("employee-home");
        model.addObject("list", employees);

        return model;
    }
}
