package com.as._3.realtimeorderprocessing.infrastructure.gateways;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;
import com.as._3.realtimeorderprocessing.infrastructure.dto.DateRangeRequest;
import com.as._3.realtimeorderprocessing.infrastructure.mapper.OrderMapper;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories.OrderRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Collection;


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

        var orderEntity = orderRepository.findById(order.id())
                .orElseThrow(() -> new OrderNotFoundException("Order não encontrada"));

        orderEntity.setCustomerName(order.customerName());
        orderEntity.setUpdatedAt(LocalDate.now());
        orderEntity.setStatus(order.status());
        orderEntity.setTotalAmount(order.totalAmount());
        orderRepository.save(orderEntity);

        return orderMapper.toOrderFromOrderEntity(orderEntity);
    }

    @Override
    public Order updateOrderStatus(Long userId, String status) {

        var orderEntity = orderRepository.findById(userId)
                .orElseThrow(()-> new OrderNotFoundException("Ordem não encontrada!"));
        orderEntity.setStatus(OrderStatus.valueOf(status));
        orderEntity.setUpdatedAt(LocalDate.now());
        orderRepository.save(orderEntity);

        return orderMapper.toOrderFromOrderEntity(orderEntity);
    }

    @Override
    public List<Order> getOrderByStatus(String status) {
         return  orderRepository.findByStatus(OrderStatus.valueOf(status))
                 .stream()
                 .map(orderEntity -> orderMapper.toOrderFromOrderEntity(orderEntity))
                 .toList();
    }

    @Override
    public List<Order> findByDateRange(LocalDate startDate, LocalDate endDate) {

        List<OrderEntity> orders = orderRepository.findByCreatedAtBetween(startDate, endDate);

        return  orders.stream()
                .map(orderEntity -> orderMapper.toOrderFromOrderEntity(orderEntity))
                .toList();
    }

    @Override
    public void DeleteOrder(Long id) {

    }


}
