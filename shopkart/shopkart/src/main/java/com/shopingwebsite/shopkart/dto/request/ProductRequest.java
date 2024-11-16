package com.shopingwebsite.shopkart.dto.request;

import com.shopingwebsite.shopkart.model.Enum.Category;

import com.shopingwebsite.shopkart.model.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    String productName;
    int price;
    Category category;
    int quantity;
    ProductStatus productStatus;
}
