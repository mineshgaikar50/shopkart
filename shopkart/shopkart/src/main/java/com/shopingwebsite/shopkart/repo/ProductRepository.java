package com.shopingwebsite.shopkart.repo;

import com.shopingwebsite.shopkart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {


}
