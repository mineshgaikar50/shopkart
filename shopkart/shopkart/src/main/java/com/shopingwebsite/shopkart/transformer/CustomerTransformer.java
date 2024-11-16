package com.shopingwebsite.shopkart.transformer;

import com.shopingwebsite.shopkart.dto.request.CustomerRequest;
import com.shopingwebsite.shopkart.dto.response.CustomerResponse;
import com.shopingwebsite.shopkart.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest)
    {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer)
    {
        return  CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}
