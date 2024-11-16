package com.shopingwebsite.shopkart.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SellerResponse {

    String name;
    String email;
    String pan;
}
