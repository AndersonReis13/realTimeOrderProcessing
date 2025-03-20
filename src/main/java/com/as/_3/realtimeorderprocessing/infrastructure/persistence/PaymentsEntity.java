package com.as._3.realtimeorderprocessing.infrastructure.persistence;

import com.as._3.realtimeorderprocessing.core.entites.Order;
import com.as._3.realtimeorderprocessing.core.enums.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_payments")
public class PaymentsEntity {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private BigDecimal amountPaid;

    private LocalDate paymentPaid;

    @OneToOne
    private OrderEntity orderId;

    public PaymentsEntity(Long id, PaymentStatus paymentStatus, BigDecimal amountPaid, LocalDate paymentPaid, OrderEntity orderId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.amountPaid = amountPaid;
        this.paymentPaid = paymentPaid;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getPaymentPaid() {
        return paymentPaid;
    }


    public OrderEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderEntity orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentsEntity that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
