package com.deliveryfood.order_service.consumer;

import com.deliveryfood.order_service.event.PaymentStatusUpdatedEvent;
import com.deliveryfood.order_service.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderService orderService;

    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = "payment.status.queue",
            containerFactory = "rabbitListenerContainerFactory")
    public void handlePaymentUpdate(PaymentStatusUpdatedEvent event) {

        System.out.println("Payment status: " + event.getPaymentStatus());

        System.out.println("===== EVENT RECEIVED =====");
        System.out.println(event.getOrderId());
        System.out.println(event.getPaymentStatus());

        orderService.updateStatus(
                event.getOrderId(),
                event.getPaymentStatus()
        );
    }

}
