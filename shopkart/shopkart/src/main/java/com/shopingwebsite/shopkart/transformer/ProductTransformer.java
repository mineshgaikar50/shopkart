package com.shopingwebsite.shopkart.transformer;

import com.shopingwebsite.shopkart.dto.request.ProductRequest;
import com.shopingwebsite.shopkart.dto.response.ProductResponse;
import com.shopingwebsite.shopkart.model.Enum.ProductStatus;
import com.shopingwebsite.shopkart.model.Product;

public class ProductTransformer {
    public static Product ProductRequestToProduct(ProductRequest productRequest)
    {
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .quantity(productRequest.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();

    }

    public static ProductResponse productToProductResponse(Product product)
    {
        return ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .category(product.getCategory())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .seller(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
