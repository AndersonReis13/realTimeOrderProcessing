package com.as._3.realtimeorderprocessing.application.usecases.payments.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgument;
import com.as._3.realtimeorderprocessing.application.usecases.payments.CancelPaymentUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.core.enums.PaymentStatus;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;

public class CancelPaymentUseCaseImpl implements CancelPaymentUseCase {


    private final PaymentGateways paymentGateways;

    public CancelPaymentUseCaseImpl(PaymentGateways paymentGateways) {
        this.paymentGateways = paymentGateways;
    }

    @Override
    public Payments cancelPayments(Long paymentId) {

        Payments payment = paymentGateways.getPaymentById(paymentId);

        if(payment == null){
            throw new IllegalArgument("Pagamento não encontrado");
        }

        Payments attPayment = new Payments(
                paymentId,
                PaymentStatus.CANCELADO,
                payment.amountPaid(),
                payment.paymentDate(),
                payment.orderId()
        );

        return attPayment;
    }
}
