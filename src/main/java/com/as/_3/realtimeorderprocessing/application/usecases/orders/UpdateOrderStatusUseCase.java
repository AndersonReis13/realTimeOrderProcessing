package com.as._3.realtimeorderprocessing.application.usecases.orders;

import com.as._3.realtimeorderprocessing.core.entites.Order;

public interface UpdateOrderStatusUseCase {
    Order updateOrderStatus(Long orderId, String status);
}
