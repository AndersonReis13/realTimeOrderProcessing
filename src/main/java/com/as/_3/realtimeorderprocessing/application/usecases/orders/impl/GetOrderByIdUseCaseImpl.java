package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import com.as._3.realtimeorderprocessing.application.usecases.orders.GetOrderByIdUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

import java.util.Optional;

public class GetOrderByIdUseCaseImpl implements GetOrderByIdUseCase{
    private final OrderGateways orderGateways;

    public GetOrderByIdUseCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }

    public Optional<Order> getOrderById(Long id){
        orderDoesExists(id);

        return orderGateways.getOrderById(id);
    }

    public void orderDoesExists(Long id){
        if(orderGateways.getOrderById(id) == null){
            throw new OrderNotFoundException("Order não encontrada");
        }
    }
}
