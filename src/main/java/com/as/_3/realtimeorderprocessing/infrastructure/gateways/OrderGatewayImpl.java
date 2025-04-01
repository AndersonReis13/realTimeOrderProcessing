package com.as._3.realtimeorderprocessing.infrastructure.gateways;

import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;
import com.as._3.realtimeorderprocessing.infrastructure.mapper.OrderMapper;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class OrderGatewayImpl implements OrderGateways {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderGatewayImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order createOrder(Order order) {
        var orderEntity = orderRepository.save(orderMapper.toOrderEntityFromOrder(order));

        return orderMapper.toOrderFromOrderEntity(orderEntity);
    }

    @Override
    public Order getOrderById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Ordem não encontrada!"));

        return orderMapper.toOrderFromOrderEntity(orderEntity);
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
