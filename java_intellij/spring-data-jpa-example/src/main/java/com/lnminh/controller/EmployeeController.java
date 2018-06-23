package com.lnminh.controller;

import com.lnminh.entity.Employee;
import com.lnminh.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @RequestMapping("/home")
    public ModelAndView showEmployees(ModelAndView modelAndView){
        List<Employee> employees = employeeManager.getAllEmployee();
        for (Employee employee: employees) {
            System.out.println(employee.getFullName());
        }
        modelAndView.setViewName("employee-home");
        modelAndView.addObject("list",employees);
        return modelAndView;
    }
}
