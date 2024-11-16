package com.shopingwebsite.shopkart.transformer;

import com.shopingwebsite.shopkart.dto.request.OrderRequest;

import com.shopingwebsite.shopkart.dto.response.OrderResponse;
import com.shopingwebsite.shopkart.dto.response.ProductResponse;
import com.shopingwebsite.shopkart.dto.request.OrderRequest;

import com.shopingwebsite.shopkart.model.Enum.OrderStatus;
import com.shopingwebsite.shopkart.model.OrderEntity;
import com.shopingwebsite.shopkart.model.Product;

import java.util.*;

import java.util.UUID;

public class OrderTransformer {

    public static OrderEntity orderRequestToOrderEntity(int totalValue){
        return OrderEntity.builder()
                .orderNo(String.valueOf(UUID.randomUUID()))
                .totalValue(totalValue)
                .orderStatus(OrderStatus.PLACED)
                .build();
    }
    public static OrderResponse orderToOrderResponse(OrderEntity order) {
        OrderResponse orderResponse = OrderResponse.builder()
                .orderNo(order.getOrderNo())
                .totalValue(order.getTotalValue())
                .orderStatus(order.getOrderStatus())
                .orderedAt(order.getOrderedAt())
                .customer(CustomerTransformer.customerToCustomerResponse(order.getCustomer()))
                .build();

        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product: order.getProducts()) {
            productResponses.add(ProductTransformer.productToProductResponse(product));
        }

        orderResponse.setProducts(productResponses);
        return orderResponse;
    }
}
