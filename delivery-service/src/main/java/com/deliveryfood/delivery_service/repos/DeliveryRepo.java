package com.deliveryfood.delivery_service.repos;

import com.deliveryfood.delivery_service.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}