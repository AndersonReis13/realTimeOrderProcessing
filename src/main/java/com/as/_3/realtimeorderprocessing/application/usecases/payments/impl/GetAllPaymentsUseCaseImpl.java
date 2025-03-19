package com.as._3.realtimeorderprocessing.application.usecases.payments.impl;

import com.as._3.realtimeorderprocessing.application.usecases.payments.GetAllPaymentsUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;

import java.util.List;

public class GetAllPaymentsUseCaseImpl implements GetAllPaymentsUseCase {

    private final PaymentGateways paymentGateways;

    public GetAllPaymentsUseCaseImpl(PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentGateways.getAllPayments();
    }
}
