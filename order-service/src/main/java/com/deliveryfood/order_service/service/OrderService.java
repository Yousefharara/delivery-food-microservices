package com.deliveryfood.order_service.service;

import com.deliveryfood.order_service.event.OrderCreatedEvent;
import com.deliveryfood.order_service.model.Order;
import com.deliveryfood.order_service.publisher.OrderEventPublisher;
import com.deliveryfood.order_service.repos.OrderRepo;
import com.deliveryfood.order_service.service.kafka.OrderProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderService(OrderRepo repository, OrderEventPublisher orderEventPublisher) {
        this.orderEventPublisher = orderEventPublisher;
        this.repository = repository;
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