package com.shopingwebsite.shopkart.controller;


import com.shopingwebsite.shopkart.dto.request.CustomerRequest;
import com.shopingwebsite.shopkart.dto.response.CustomerResponse;
import com.shopingwebsite.shopkart.model.Customer;
import com.shopingwebsite.shopkart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        try{
            CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
            return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Duplicate mail",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/age/{age}")
    public ResponseEntity findByAge(@PathVariable("age") int age) {
        List<CustomerResponse> customerResponses = customerService.findByAge(age);
        return new ResponseEntity<>(customerResponses,HttpStatus.ACCEPTED);
    }
}
