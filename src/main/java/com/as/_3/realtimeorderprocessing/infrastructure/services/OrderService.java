package com.as._3.realtimeorderprocessing.infrastructure.services;

import com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

     
    

}
