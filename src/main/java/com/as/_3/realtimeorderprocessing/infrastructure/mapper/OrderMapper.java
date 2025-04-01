package com.as._3.realtimeorderprocessing.infrastructure.mapper;

import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.infrastructure.dto.OrderRequest;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderMapper {

    public OrderEntity toOrderEntityFromOrder(Order order){
        return new OrderEntity(order.id(),
                order.customerName(),
                order.totalAmount(),
                order.status(),
                LocalDate.now(),
                order.updatedAt());
    }


    public Order toOrderFromOrderEntity (OrderEntity orderEntity){
        return new Order(orderEntity.getId(),
                orderEntity.getCustomerName(),
                orderEntity.getTotalAmount(),
                orderEntity.getStatus(),
                orderEntity.getCreatedAt(),
                orderEntity.getUpdatedAt());
    }


    public OrderEntity toOrderDtoFromOrderEntityCreate(OrderRequest dto){
        return new OrderEntity(dto.id(),
                dto.customerName(),
                dto.totalAmount(),
                OrderStatus.valueOf(dto.orderStatus()),
                LocalDate.now(),
                null);
    }

    public Order toOrderDtoFromOrder(OrderRequest dto){
        return new Order(dto.id(),
                dto.customerName(),
                dto.totalAmount(),
                OrderStatus.valueOf(dto.orderStatus()),
                LocalDate.now(),
                null);
    }




}
