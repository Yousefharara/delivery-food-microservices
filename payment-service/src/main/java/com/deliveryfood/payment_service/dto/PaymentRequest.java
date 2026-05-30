package com.deliveryfood.payment_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PaymentRequest {

    private Long orderId;

    private Double amount;

    private String paymentMethod;
}

