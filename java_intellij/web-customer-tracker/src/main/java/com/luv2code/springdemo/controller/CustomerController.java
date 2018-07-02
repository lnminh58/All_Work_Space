package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    @PostMapping("/list")
//    @GetMapping("/list" )
    @RequestMapping("/list")
    public String listCustomer(Model model){

        List<Customer> customers = customerService.getCustomers();

        for (Customer customer: customers) {
            System.out.println(customer.toString());
        }

        model.addAttribute("customers",customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model model){

        model.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        System.out.println("HELLO :" + customer);
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model theModel){
        // get the customer from the database
        Customer customer = customerService.getCustomer(customerId);
//        set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
