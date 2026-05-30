package com.deliveryfood.payment_service.publisher;

import com.deliveryfood.payment_service.config.RabbitMQConfig;
import com.deliveryfood.payment_service.event.PaymentStatusUpdatedEvent;
import com.deliveryfood.payment_service.model.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public PaymentEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishPaymentStatusUpdated(Payment payment) {

        PaymentStatusUpdatedEvent event =
                new PaymentStatusUpdatedEvent();

        event.setOrderId(payment.getOrderId());
        event.setPaymentId(payment.getId());
        event.setPaymentStatus(payment.getPaymentStatus());
        event.setAmount(payment.getAmount());

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.PAYMENT_QUEUE,
                event
        );
    }
}