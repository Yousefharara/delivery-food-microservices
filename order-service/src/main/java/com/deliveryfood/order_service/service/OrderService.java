package com.deliveryfood.order_service.service;

import com.deliveryfood.order_service.event.OrderAcceptedEvent;
import com.deliveryfood.order_service.event.OrderCreatedEvent;
import com.deliveryfood.order_service.model.Order;
import com.deliveryfood.order_service.publisher.OrderAcceptedPublisher;
import com.deliveryfood.order_service.publisher.OrderEventPublisher;
import com.deliveryfood.order_service.repos.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repository;
    private final OrderEventPublisher orderEventPublisher;
    private final OrderAcceptedPublisher orderAcceptedPublisher;

    public OrderService(OrderRepo repository, OrderEventPublisher orderEventPublisher, OrderAcceptedPublisher orderAcceptedPublisher) {
        this.orderEventPublisher = orderEventPublisher;
        this.repository = repository;
        this.orderAcceptedPublisher = orderAcceptedPublisher;
    }

    public Order createOrder(Order orderRequest) {
        orderRequest.setStatus("CREATED");
        Order order = repository.save(orderRequest);

        orderEventPublisher.publish(
                new OrderCreatedEvent(
                        order.getId(),
                        order.getCustomerId(),
                        order.getItemName(),
                        order.getQuantity()
                )
        );

        return order;
    }


    public Order updateStatus(Long orderId, String status) {

        Order order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        Order saveOrder = repository.save(order);

        if(status.equals("ACCEPTED")) {

            orderAcceptedPublisher.publish(
                    new OrderAcceptedEvent(
                            order.getId(),
                            order.getCustomerId(),
                            order.getStatus()
                    )
            );
        }

        return saveOrder;

    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}