package com.as._3.realtimeorderprocessing.infrastructure.persistence.repositories;

import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.infrastructure.persistence.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentsEntity, Long> {
}
