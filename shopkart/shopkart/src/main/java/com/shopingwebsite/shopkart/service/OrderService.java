package com.shopingwebsite.shopkart.service;

import com.shopingwebsite.shopkart.dto.request.ItemRequest;
import com.shopingwebsite.shopkart.dto.request.OrderRequest;
import com.shopingwebsite.shopkart.dto.response.OrderResponse;
import com.shopingwebsite.shopkart.exception.CustomerNotFound;
import com.shopingwebsite.shopkart.exception.ProductNotFoundException;
import com.shopingwebsite.shopkart.model.Customer;
import com.shopingwebsite.shopkart.model.Enum.ProductStatus;
import com.shopingwebsite.shopkart.model.OrderEntity;
import com.shopingwebsite.shopkart.model.Product;
import com.shopingwebsite.shopkart.repo.CustomerRepository;
import com.shopingwebsite.shopkart.repo.OrderRepository;
import com.shopingwebsite.shopkart.repo.ProductRepository;
import com.shopingwebsite.shopkart.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.shopingwebsite.shopkart.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

   @Autowired
   JavaMailSender javaMailSender;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(orderRequest.getCustomerEmail());


        //check whether the customer is valid or not i.e. given below.
        if (customerOptional.isEmpty()) {

            throw new CustomerNotFound("Email is Not Valid");
        }


        Customer customer = customerOptional.get();
        List<Product> productsRequested = new ArrayList<>();
        int totalValue = 0;


        for (ItemRequest itemRequest : orderRequest.getItemRequest()) {
            Optional<Product> optionalProduct = productRepository.findById(itemRequest.getId());
            if (optionalProduct.isEmpty()) {
                throw new ProductNotFoundException("Sorry! the product id=" + itemRequest.getId() + "is invalid");
            }

            Product product = optionalProduct.get();
            if (product.getQuantity() < itemRequest.getRequiredQuantity()) {
                throw new ProductNotFoundException("Sorry, the product is not available");
            }
            product.setQuantity(product.getQuantity() - itemRequest.getRequiredQuantity());
            if (product.getQuantity() == 0) {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }

            totalValue += itemRequest.getRequiredQuantity() * product.getPrice();
            productsRequested.add(product);
        }
        OrderEntity order = OrderTransformer.orderRequestToOrderEntity(totalValue);
        order.setCustomer(customer);
        order.setProducts(productsRequested);

        OrderEntity savedOrder = orderRepository.save(order);


        for (Product product : productsRequested) {
            product.getOrders().add(order);
        }
        customer.getOrders().add(savedOrder);
        //save customer and product
        customerRepository.save(customer); // customer + order;
        productRepository.saveAll(productsRequested);
        sendEmail(savedOrder);


        return OrderTransformer.orderToOrderResponse(savedOrder);
    }

        private void sendEmail(OrderEntity savedOrder) {
            String text = "Hi " + savedOrder.getCustomer().getName() + " your order is placed with total value = "+ savedOrder.getTotalValue();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("acciojobspring@gmail.com");
            message.setTo(savedOrder.getCustomer().getEmail());
            message.setSubject("Order Placed");
            message.setText(text);
            javaMailSender.send(message);
        }


    }

