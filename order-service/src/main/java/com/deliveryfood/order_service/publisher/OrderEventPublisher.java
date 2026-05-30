package com.deliveryfood.order_service.publisher;

import com.deliveryfood.order_service.config.RabbitMQConfig;
import com.deliveryfood.order_service.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OrderCreatedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.ORDER_QUEUE,
                event
        );
    }
}