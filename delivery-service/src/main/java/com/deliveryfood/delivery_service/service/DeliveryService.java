package com.deliveryfood.delivery_service.service;

import com.deliveryfood.delivery_service.event.DeliveryStatusUpdatedEvent;
import com.deliveryfood.delivery_service.event.OrderReadyForDeliveryEvent;
import com.deliveryfood.delivery_service.model.Delivery;
import com.deliveryfood.delivery_service.publisher.DeliveryEventPublisher;
import com.deliveryfood.delivery_service.repos.DeliveryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryRepo repository;
    private final DeliveryEventPublisher publisher;

    public DeliveryService(
            DeliveryRepo repository,
            DeliveryEventPublisher publisher
    ) {
        this.repository = repository;
        this.publisher = publisher;
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

    public List<Delivery> getAll() {
        return repository.findAll();
    }

    public Delivery getById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Delivery updateStatus(
            Long id,
            String status
    ) {

        Delivery delivery = repository.findById(id)
                .orElseThrow();

        delivery.setDeliveryStatus(status);

        Delivery saved =  repository.save(delivery);

        publisher.publish(
                new DeliveryStatusUpdatedEvent(
                        delivery.getId(),
                        delivery.getCustomerId(),
                        delivery.getDeliveryStatus()
                )
        );

        return saved;

    }


}