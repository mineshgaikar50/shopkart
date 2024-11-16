package com.shopingwebsite.shopkart.service;

import com.shopingwebsite.shopkart.dto.request.SellerRequest;
import com.shopingwebsite.shopkart.dto.response.SellerResponse;
import com.shopingwebsite.shopkart.model.Seller;
import com.shopingwebsite.shopkart.repo.SellerRepository;
import com.shopingwebsite.shopkart.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {


    @Autowired
    SellerRepository sellerRepository;
    public SellerResponse addSeller(SellerRequest sellerRequest)
    {
        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);

    }
}
