package com.as._3.realtimeorderprocessing.infrastructure.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id,
                           String customerName,
                           BigDecimal totalAmount,
                           String orderStatus) {
}
