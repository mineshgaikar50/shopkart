package com.shopingwebsite.shopkart.service;


import com.shopingwebsite.shopkart.dto.request.ProductRequest;
import com.shopingwebsite.shopkart.dto.response.ProductResponse;
import com.shopingwebsite.shopkart.exception.SellerNotFoundException;
import com.shopingwebsite.shopkart.model.Product;
import com.shopingwebsite.shopkart.model.Seller;
import com.shopingwebsite.shopkart.repo.SellerRepository;
import com.shopingwebsite.shopkart.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(ProductRequest productRequest, String sellerEmail){

        Optional<Seller> sellerOptional = sellerRepository.findByEmail(sellerEmail);
        if(sellerOptional.isEmpty()){
            throw new SellerNotFoundException("Invalid seller email");
        }

        Seller seller = sellerOptional.get();

        Product product = ProductTransformer.ProductRequestToProduct(productRequest);
        product.setSeller(seller);

        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both seller and product
        int size = seller.getProducts().size();

        return  ProductTransformer.productToProductResponse(savedSeller.getProducts().get(size-1));
    }
}
