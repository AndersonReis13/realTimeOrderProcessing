package com.as._3.realtimeorderprocessing.application.usecases.orders.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgumentOrder;
import com.as._3.realtimeorderprocessing.application.usecases.orders.FindByDateRangeUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;

import java.time.LocalDate;
import java.util.List;

public class FindByDateRangeUseCaseImpl implements FindByDateRangeUseCase {

    private final OrderGateways orderGateways;

    public FindByDateRangeUseCaseImpl(OrderGateways orderGateways) {
        this.orderGateways = orderGateways;
    }

    public List<Order> findByDateRange(LocalDate startDate, LocalDate endDate){
        if(endDate.isBefore(startDate)){
            throw new IllegalArgumentOrder("A data final não pode ser maior que a data inicial");
        }

        return orderGateways.findByDateRange(startDate, endDate);
    }
}
