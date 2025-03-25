package com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories;

import com.as._3.realtimeorderprocessing.infrastructure.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
