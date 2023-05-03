package com.example.bankaccountservice.web;

import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerGraphQLController {
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> Customers(){
        return customerRepository.findAll();
    }
}
