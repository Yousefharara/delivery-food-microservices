package com.deliveryfood.customer_service.consumer;

import com.deliveryfood.customer_service.event.DeliveryStatusUpdatedEvent;
import com.deliveryfood.customer_service.model.Customer;
import com.deliveryfood.customer_service.repos.CustomerRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class CustomerConsumer {

    private final CustomerRepo customerRepo;

    public CustomerConsumer(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @RabbitListener(
            queues = "customer.notification.queue",
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void receive(
            DeliveryStatusUpdatedEvent event
    ) {


        System.out.println("===== DELIVERY UPDATE =====");
        Customer customer = customerRepo.findById(event.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        System.out.println(
                "Hello " + customer.getName() +
                        ", your order is now " + event.getDeliveryStatus()
        );

        System.out.println("Customer ID: " + event.getCustomerId());
        System.out.println("Delivery Status: " + event.getDeliveryStatus());

        System.out.println("Message sent to customer successfully 🚀");

    }

}
