package com.as._3.realtimeorderprocessing.application.usecases.payments;

import com.as._3.realtimeorderprocessing.core.entites.Payments;

import java.util.Optional;

public interface GetPaymentByIdUseCase {

    Payments getPaymentById(Long id);
}
