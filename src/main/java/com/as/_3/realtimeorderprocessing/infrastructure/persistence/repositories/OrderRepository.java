package com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories;

import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    
    List<OrderEntity> findByStatus(OrderStatus status);
    List<OrderEntity> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
}
