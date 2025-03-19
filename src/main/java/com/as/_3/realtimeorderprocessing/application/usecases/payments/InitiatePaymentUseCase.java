package com.as._3.realtimeorderprocessing.application.usecases.payments;

import com.as._3.realtimeorderprocessing.core.entites.Payments;

public interface InitiatePaymentUseCase {
    Payments initiatePayment(Long orderId, Payments payments);
}
