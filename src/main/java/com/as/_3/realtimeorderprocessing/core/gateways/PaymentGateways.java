package com.as._3.realtimeorderprocessing.core.gateways;

import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.entites.Payments;

import java.util.List;

public interface PaymentGateways {

    Payments initiatePayment(Long orderId, Payments payments);
    Payments getPaymentById(Long id);
    List<Payments> getAllPayments();
    Payments confirmPayment(Long paymentId);
    Payments cancelPayments(Long paymentId);


}
