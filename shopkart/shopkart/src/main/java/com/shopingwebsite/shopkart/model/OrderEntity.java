package com.shopingwebsite.shopkart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopingwebsite.shopkart.model.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderNo;

    double totalValue;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @CreationTimestamp
    Date orderedAt;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToMany(mappedBy = "orders")
    @JsonIgnore
    List<Product>products =new ArrayList<>();
}
