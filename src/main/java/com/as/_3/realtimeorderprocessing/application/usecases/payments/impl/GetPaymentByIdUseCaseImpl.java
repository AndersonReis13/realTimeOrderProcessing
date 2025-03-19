package com.as._3.realtimeorderprocessing.application.usecases.payments.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgument;
import com.as._3.realtimeorderprocessing.application.usecases.payments.GetPaymentByIdUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;

import java.util.Optional;

public class GetPaymentByIdUseCaseImpl implements GetPaymentByIdUseCase {

    private final PaymentGateways paymentGateways;

    public GetPaymentByIdUseCaseImpl(PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }

    @Override
    public Payments getPaymentById(Long id) {

        Payments payments = paymentGateways.getPaymentById(id);

        if(payments == null){
            throw new IllegalArgument("Pagamento não encontado");
        }

        return payments;
    }
}
