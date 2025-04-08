package com.as._3.realtimeorderprocessing.core.entites;

import com.as._3.realtimeorderprocessing.core.enums.OrderStatus;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Order (Long id,
                     String customerName,
                     BigDecimal totalAmount,
                     OrderStatus status,
                     LocalDate createdAt,
                     LocalDate updatedAt) {
}
