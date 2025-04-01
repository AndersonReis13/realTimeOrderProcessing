package com.as._3.realtimeorderprocessing.infrastructure.controllers;

import com.as._3.realtimeorderprocessing.infrastructure.dto.OrderRequest;
import com.as._3.realtimeorderprocessing.infrastructure.gateways.OrderGatewayImpl;
import com.as._3.realtimeorderprocessing.infrastructure.mapper.OrderMapper;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import com.as._3.realtimeorderprocessing.infrastructure.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {
     private final OrderGatewayImpl orderGateway;
     private final OrderService orderService;
     private final OrderMapper orderMapper;


    public OrderController(OrderGatewayImpl orderGateway, OrderService orderService, OrderMapper orderMapper) {
        this.orderGateway = orderGateway;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request){
        var order = orderMapper.toOrderDtoFromOrder(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderGateway.createOrder(order));
    }
}
