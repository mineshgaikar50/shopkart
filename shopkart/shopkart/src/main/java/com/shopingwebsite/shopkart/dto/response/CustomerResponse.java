package com.shopingwebsite.shopkart.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    String name;
    String email;
}
