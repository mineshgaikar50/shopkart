package com.shopingwebsite.shopkart.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemRequest {


    int id;
    int requiredQuantity;

}
