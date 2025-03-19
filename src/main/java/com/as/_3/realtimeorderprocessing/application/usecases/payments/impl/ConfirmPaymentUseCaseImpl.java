package com.as._3.realtimeorderprocessing.application.usecases.payments.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgument;
import com.as._3.realtimeorderprocessing.application.usecases.payments.ConfirmPaymentUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.core.enums.PaymentStatus;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;

import java.util.Optional;

public class ConfirmPaymentUseCaseImpl implements ConfirmPaymentUseCase {

    private final PaymentGateways paymentGateways;

    public ConfirmPaymentUseCaseImpl(PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }

    @Override
    public Payments confirmPayment(Long paymentId) {

        Payments payment = paymentGateways.getPaymentById(paymentId);

        if(payment == null){
            throw new IllegalArgument("Pagamento não encontrado!");
        }

        Payments attPayment = new Payments(paymentId,
                PaymentStatus.APROVADO,
                payment.amountPaid(),
                payment.paymentDate(),
                payment.orderId()
        );

        return attPayment;
    }
}
