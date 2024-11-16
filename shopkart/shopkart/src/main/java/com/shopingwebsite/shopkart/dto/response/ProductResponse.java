package com.shopingwebsite.shopkart.dto.response;

import com.shopingwebsite.shopkart.model.Enum.Category;
import com.shopingwebsite.shopkart.model.Enum.ProductStatus;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    String productName;
    int price;
    Category category;
    int quantity;
    ProductStatus productStatus;

    SellerResponse seller;
}
