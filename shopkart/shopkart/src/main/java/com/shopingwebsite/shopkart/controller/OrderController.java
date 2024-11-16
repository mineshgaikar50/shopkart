package com.shopingwebsite.shopkart.controller;


import com.shopingwebsite.shopkart.dto.request.OrderRequest;
import com.shopingwebsite.shopkart.dto.response.OrderResponse;
import com.shopingwebsite.shopkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {


    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest){
        try {
            OrderResponse orderResponse = orderService.placeOrder(orderRequest);
            return new ResponseEntity(orderResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
