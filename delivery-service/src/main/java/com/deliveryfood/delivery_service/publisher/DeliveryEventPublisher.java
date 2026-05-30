package com.deliveryfood.delivery_service.publisher;

import com.deliveryfood.delivery_service.config.RabbitMQConfig;
import com.deliveryfood.delivery_service.event.DeliveryStatusUpdatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliveryEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public DeliveryEventPublisher(
            RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(
            DeliveryStatusUpdatedEvent event
    ) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CUSTOMER_QUEUE,
                event
        );
    }
}