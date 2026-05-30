package com.deliveryfood.payment_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {

    private Long id;

    private Long orderId;

    private String paymentStatus;
    private String message;

    public PaymentResponse() {
    }

    public PaymentResponse(Long id, String paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public PaymentResponse(Long id, Long orderId, String paymentStatus, String message) {
        this.id = id;
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.message = message;
    }

}