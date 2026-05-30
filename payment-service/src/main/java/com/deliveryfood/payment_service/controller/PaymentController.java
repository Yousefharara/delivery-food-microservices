package com.deliveryfood.payment_service.controller;

import com.deliveryfood.payment_service.dto.PaymentRequest;
import com.deliveryfood.payment_service.dto.PaymentResponse;
import com.deliveryfood.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentResponse createPayment(
            @RequestBody PaymentRequest request
    ) {
        return service.savePayment(request);
    }




    @PostMapping("/{id}/process")
    public String processPayment(@PathVariable Long id) {
        service.processPayment(id);
        return "Payment processed successfully";
    }

}