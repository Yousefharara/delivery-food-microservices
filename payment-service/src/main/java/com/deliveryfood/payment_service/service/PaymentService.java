package com.deliveryfood.payment_service.service;

import com.deliveryfood.payment_service.dto.PaymentRequest;
import com.deliveryfood.payment_service.dto.PaymentResponse;
import com.deliveryfood.payment_service.event.OrderCreatedEvent;
import com.deliveryfood.payment_service.model.Payment;
import com.deliveryfood.payment_service.repos.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepo repository;

    public PaymentService(PaymentRepo repository) {
        this.repository = repository;
    }

    public PaymentResponse savePayment(PaymentRequest request) {

        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .paymentStatus("PENDING")
                .build();

        Payment savedPayment = repository.save(payment);

        return PaymentResponse.builder()
                .id(savedPayment.getId())
                .orderId(savedPayment.getOrderId())
                .paymentStatus(savedPayment.getPaymentStatus())
                .message("Payment created successfully")
                .build();
    }

    public void createPaymentFromEvent(OrderCreatedEvent event) {

        Payment payment = Payment.builder()
                .orderId(event.getOrderId())
                .paymentStatus("PENDING")
                .paymentMethod("CASH")
                .build();

        repository.save(payment);
    }
}