package com.as._3.realtimeorderprocessing.application.usecases.payments.impl;

import com.as._3.realtimeorderprocessing.application.exceptions.orders.IllegalArgument;
import com.as._3.realtimeorderprocessing.application.exceptions.orders.OrderNotFoundException;
import com.as._3.realtimeorderprocessing.application.usecases.payments.InitiatePaymentUseCase;
import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.entites.Payments;
import com.as._3.realtimeorderprocessing.core.enums.PaymentStatus;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;

import java.math.BigDecimal;
import java.util.Optional;

public class InitiatePaymentUseCaseImpl implements InitiatePaymentUseCase {

    private final PaymentGateways paymentGateways;
    private final OrderGateways orderGateways;

    public InitiatePaymentUseCaseImpl(PaymentGateways paymentGateways, OrderGateways orderGateways) {
        this.paymentGateways = paymentGateways;
        this.orderGateways = orderGateways;
    }

    @Override
    public Payments initiatePayment(Long orderId, Payments payments) {

        Optional<Order> order = orderGateways.getOrderById(orderId);

        if(order.isEmpty()){
            throw new OrderNotFoundException("A ordem não encontrada!");
        }

        if(payments.paymentStatus() == PaymentStatus.APROVADO){
            throw new IllegalArgument("Um pagamento que acabou de ser iniciado não pode começar como aprovado!");
        }

        if(payments.paymentStatus() == PaymentStatus.CANCELADO){
            throw new IllegalArgument("Um pagamento que acabou de ser iniciado não pode ser cancelado");
        }

        if(payments.amountPaid().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgument("O valor de pagamento não pode ser negativo");
        }

        return payments;
    }
}
