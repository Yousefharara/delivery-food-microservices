package com.deliveryfood.payment_service.consumer;

import com.deliveryfood.payment_service.config.RabbitMQConfig;
import com.deliveryfood.payment_service.event.OrderCreatedEvent;
import com.deliveryfood.payment_service.model.Payment;
import com.deliveryfood.payment_service.service.PaymentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {


    private final PaymentService paymentService;

    public PaymentConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @RabbitListener(
            queues = RabbitMQConfig.ORDER_QUEUE,
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void receive(OrderCreatedEvent event){

        paymentService.createPaymentFromEvent(event);

        System.out.println(
                "Payment created for order: "
                        + event.getOrderId()
        );
    }


}