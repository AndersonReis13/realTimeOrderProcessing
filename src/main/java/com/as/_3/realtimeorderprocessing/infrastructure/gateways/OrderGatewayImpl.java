package com.as._3.realtimeorderprocessing.infrastructure.gateways;

import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.List;

public class OrderGatewayImpl implements OrderGateways {

    private final OrderRepository orderRepository;

    public OrderGatewayImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrderStatus(Long userId, String status) {
        return null;
    }

    @Override
    public List<Order> getOrderByStatus(String status) {
        return List.of();
    }

    @Override
    public List<Order> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    @Override
    public void DeleteOrder(Long id) {

    }
}
