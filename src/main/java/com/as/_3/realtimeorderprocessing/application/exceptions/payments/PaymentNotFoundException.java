package com.as._3.realtimeorderprocessing.application.exceptions.payments;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String msg) {
        super(msg);
    }
}
