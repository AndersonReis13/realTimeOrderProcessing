package com.as._3.realtimeorderprocessing.application.usecases.orders;

import com.as._3.realtimeorderprocessing.core.entites.Order;

import java.time.LocalDate;
import java.util.List;

public interface FindByDateRangeUseCase {
    List<Order> findByDateRange(LocalDate startDate, LocalDate endDate);
}
