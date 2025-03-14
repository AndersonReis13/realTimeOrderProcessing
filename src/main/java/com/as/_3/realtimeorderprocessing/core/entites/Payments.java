package com.as._3.realtimeorderprocessing.core.entites;

import com.as._3.realtimeorderprocessing.core.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Payments(Long id,
                       PaymentStatus paymentStatus,
                       BigDecimal amountPaid,
                       LocalDate paymentDate,
                       Long orderId) {
}
