package com.shopingwebsite.shopkart.dto.response;

import com.shopingwebsite.shopkart.model.Enum.OrderStatus;
import lombok.*;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    String orderNo;

    double totalValue;

    OrderStatus orderStatus;

    Date orderedAt;

    CustomerResponse customer;

    ProductResponse productResponse;

    List<ProductResponse> products;
}
