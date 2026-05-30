package com.deliveryfood.delivery_service.consumer;

import com.deliveryfood.delivery_service.event.OrderReadyForDeliveryEvent;
import com.deliveryfood.delivery_service.service.DeliveryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryConsumer {

    private final DeliveryService deliveryService;

    public DeliveryConsumer(
            DeliveryService deliveryService
    ) {
        this.deliveryService = deliveryService;
    }

    @RabbitListener(
            queues = "delivery.queue",
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void receive(
            OrderReadyForDeliveryEvent event
    ) {

        System.out.println(
                "Received Order For Delivery : "
                        + event.getOrderId()
        );

        deliveryService.createDelivery(event);
    }
}