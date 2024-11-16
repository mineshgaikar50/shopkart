package com.shopingwebsite.shopkart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopingwebsite.shopkart.model.Enum.Category;
import com.shopingwebsite.shopkart.model.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    int price;

    @Enumerated(EnumType.STRING)
    Category category;

    int quantity;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Seller seller;

    @ManyToMany
    @JoinTable(name = "product_order", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_entity_id"))
    @JsonIgnore
    List<OrderEntity> orders = new ArrayList<>();
}
