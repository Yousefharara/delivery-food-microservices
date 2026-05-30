package com.deliveryfood.payment_service.repos;

import com.deliveryfood.payment_service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long>{
}