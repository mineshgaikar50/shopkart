package com.shopingwebsite.shopkart.service;

import com.shopingwebsite.shopkart.dto.request.CustomerRequest;

import com.shopingwebsite.shopkart.dto.response.CustomerResponse;
import com.shopingwebsite.shopkart.model.Customer;
import com.shopingwebsite.shopkart.repo.CustomerRepository;
import com.shopingwebsite.shopkart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> findByAge(int age)
    {
        List<Customer>customers = customerRepository.findByAge(age);
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for (Customer customer : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
