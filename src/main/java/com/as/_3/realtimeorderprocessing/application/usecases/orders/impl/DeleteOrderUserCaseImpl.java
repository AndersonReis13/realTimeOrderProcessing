package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import com.as._3.realtimeorderprocessing.application.usecases.orders.DeleteOrderUseCase;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

public class DeleteOrderUserCaseImpl implements DeleteOrderUseCase {

    private final OrderGateways orderGateways;

    public DeleteOrderUserCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }

    @Override
    public void deleteOrder(Long id) {
        orderDoesExists(id);

        orderGateways.DeleteOrder(id);
    }

    public void orderDoesExists(Long id){
        if(orderGateways.getOrderById(id) == null){
            throw new OrderNotFoundException("Order não encontrada");
        }
    }
}
