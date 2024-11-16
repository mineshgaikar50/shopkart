package com.shopingwebsite.shopkart.repo;

import com.shopingwebsite.shopkart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

     List<Customer> findByAge(int age);
     Optional<Customer> findByEmail(String email);
}
