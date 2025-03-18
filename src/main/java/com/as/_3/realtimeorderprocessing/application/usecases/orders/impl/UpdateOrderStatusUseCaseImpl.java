package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgumentOrder;
import com.as._3.realtimeorderprocessing.application.usecases.orders.UpdateOrderStatusUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

import java.util.Optional;

public class UpdateOrderStatusUseCaseImpl implements UpdateOrderStatusUseCase {
    private final OrderGateways orderGateways;

    public UpdateOrderStatusUseCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }



    @Override
    public Order updateOrderStatus(Long orderId, String status) {
       Optional<Order> order = orderGateways.getOrderById(orderId);

       return null;
    }
}
