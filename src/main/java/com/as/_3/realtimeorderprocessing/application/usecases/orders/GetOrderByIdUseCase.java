package com.as._3.realtimeorderprocessing.application.usecases.orders;

import com.as._3.realtimeorderprocessing.core.entites.Order;

import java.util.Optional;

public interface GetOrderByIdUseCase {
    Order getOrderById(Long id);
}
