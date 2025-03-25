package com.as._3.realtimeorderprocessing.core.gateways;

import com.as._3.realtimeorderprocessing.core.entites.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderGateways {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    Order updateOrder(Order order);

    Order updateOrderStatus(Long userId, String status);

    List<Order> getOrderByStatus(String status);

    List<Order> findByDateRange(LocalDate startDate, LocalDate endDate);

    void DeleteOrder(Long id);



}
