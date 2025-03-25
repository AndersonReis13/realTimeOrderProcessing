package com.as._3.realtimeorderprocessing.infrastructure.config;

import com.as._3.realtimeorderprocessing.application.usecases.orders.*;
import com.as._3.realtimeorderprocessing.application.usecases.orders.impl.*;
import com.as._3.realtimeorderprocessing.application.usecases.payments.*;
import com.as._3.realtimeorderprocessing.application.usecases.payments.impl.*;
import com.as._3.realtimeorderprocessing.core.gateways.OrderGateways;
import com.as._3.realtimeorderprocessing.core.gateways.PaymentGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfigs {

    /*Order Beans*/
    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderGateways orderGateways){
        return new CreateOrderUserCaseImpl(orderGateways);
    }

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(OrderGateways orderGateways){
        return new DeleteOrderUserCaseImpl(orderGateways);
    }

    @Bean
    public FindByDateRangeUseCase findByDateRangeUseCase(OrderGateways orderGateways){
        return new FindByDateRangeUseCaseImpl(orderGateways);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase(OrderGateways orderGateways){
        return new GetOrderByIdUseCaseImpl(orderGateways);
    }

    @Bean
    public UpdateOrderStatusUseCase updateOrderStatusUseCase(OrderGateways orderGateways){
        return new UpdateOrderStatusUseCaseImpl(orderGateways);
    }

    /*Payments Beans*/
    public InitiatePaymentUseCase initiatePaymentUseCase(PaymentGateways paymentGateways, OrderGateways orderGateways){
        return new InitiatePaymentUseCaseImpl(paymentGateways, orderGateways);
    }

    public ConfirmPaymentUseCase confirmPaymentUseCase(PaymentGateways paymentGateways){
        return new ConfirmPaymentUseCaseImpl(paymentGateways);
    }

    public CancelPaymentUseCase cancelPaymentUseCase(PaymentGateways paymentGateways){
        return new CancelPaymentUseCaseImpl(paymentGateways);
    }

    public GetAllPaymentsUseCase getAllPaymentsUseCase(PaymentGateways paymentGateways){
        return new GetAllPaymentsUseCaseImpl(paymentGateways);
    }

    public GetPaymentByIdUseCase getPaymentByIdUseCase(PaymentGateways paymentGateways){
        return new GetPaymentByIdUseCaseImpl(paymentGateways);
    }
}
