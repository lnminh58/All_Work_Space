package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomer(Model model){

        List<Customer> customers = customerDAO.getCustomers();

        for (Customer customer: customers) {
            System.out.println(customer.toString());
        }

        model.addAttribute("customers",customers);

        return "list-customers";
    }
}
