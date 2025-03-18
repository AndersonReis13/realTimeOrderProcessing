package com.as._3.realtimeorderprocessing.application.exceptions.orders;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
