package com.shopingwebsite.shopkart.dto.request;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequest {


    List<ItemRequest> itemRequest;
    String customerEmail;


}
