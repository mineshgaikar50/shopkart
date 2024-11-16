package com.shopingwebsite.shopkart.dto.request;

import com.shopingwebsite.shopkart.model.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    String name;

    int age;

   // @Column(unique = true, nullable = false)
    String email;

    //@Enumerated(EnumType.STRING)
    Gender gender;
}
