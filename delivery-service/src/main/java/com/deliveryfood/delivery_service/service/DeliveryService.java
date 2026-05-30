package com.deliveryfood.delivery_service.service;

import com.deliveryfood.delivery_service.event.OrderReadyForDeliveryEvent;
import com.deliveryfood.delivery_service.model.Delivery;
import com.deliveryfood.delivery_service.repos.DeliveryRepo;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryRepo repository;

    public DeliveryService(DeliveryRepo repository) {
        this.repository = repository;
    }

    public void createDelivery(OrderReadyForDeliveryEvent event) {

        Delivery delivery = Delivery.builder()
                .orderId(event.getOrderId())
                .customerId(event.getCustomerId())
                .deliveryStatus("WAITING")
                .estimatedTime(30)
                .currentLocation("Restaurant")
                .destination("Customer Address")
                .build();

        repository.save(delivery);

        System.out.println(
                "Delivery Created For Order : "
                        + event.getOrderId()
        );
    }


}