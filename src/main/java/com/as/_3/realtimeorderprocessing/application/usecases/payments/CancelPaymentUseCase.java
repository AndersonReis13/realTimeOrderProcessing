package com.as._3.realtimeorderprocessing.application.usecases.payments;

import com.as._3.realtimeorderprocessing.core.entites.Payments;

public interface CancelPaymentUseCase {
    Payments cancelPayments(Long paymentId);
}
