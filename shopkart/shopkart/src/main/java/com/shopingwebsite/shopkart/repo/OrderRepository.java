package com.shopingwebsite.shopkart.repo;

import com.shopingwebsite.shopkart.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

}