package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import com.as._3.realtimeorderprocessing.application.usecases.orders.UpdateOrderStatusUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateOrderStatusUseCaseImpl implements UpdateOrderStatusUseCase {
    private final OrderGateways orderGateways;

    public UpdateOrderStatusUseCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }



    @Override
    public Order updateOrderStatus(Long orderId, String status) {
       Order order = orderGateways.getOrderById(orderId);

       if(order == null){
           throw new OrderNotFoundException("Nenhum order foi encontrado!");
       }

       Order newOrder = new Order(
               orderId,
               order.customerName(),
               order.totalAmount(),
               OrderStatus.PAGO,
               order.createdAt(),
               LocalDate.now()
       );

       return newOrder;
    }
}
