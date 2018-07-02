package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(int customerId);

    public void saveCustomer (Customer customer);

    public void deleteCustomer(int customerId);
}
