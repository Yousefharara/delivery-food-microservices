package com.deliveryfood.order_service.publisher;

import com.deliveryfood.order_service.config.RabbitMQConfig;
import com.deliveryfood.order_service.event.OrderAcceptedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderAcceptedPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderAcceptedPublisher(
            RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OrderAcceptedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.DELIVERY_QUEUE,
                event
        );
    }
}