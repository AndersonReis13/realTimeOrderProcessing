package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgument;
import com.as._3.realtimeorderprocessing.application.usecases.orders.CreateOrderUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateOrderUserCaseImpl implements CreateOrderUseCase {

    private final OrderGateways orderGateways;

    public CreateOrderUserCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }

    @Override
    public Order createOrderUseCase(Order order) {
        LocalDate now = LocalDate.now();

        if(order.createdAt().isBefore(now)){
            throw new IllegalArgument("A data de criação não pode ser antes do tempo atual");
        }

        if(order.status() == OrderStatus.CANCELADO){
            throw new IllegalArgument("A ordem não pode ser criada como cancelada");
        }

        if(order.totalAmount().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgument("O valor do pagamento não pode ser 0");
        }

        return orderGateways.createOrder(order);
    }
}
