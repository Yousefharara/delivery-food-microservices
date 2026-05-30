package com.deliveryfood.order_service.event;

public class OrderAcceptedEvent {

    private Long orderId;
    private Long customerId;
    private String status;

    public OrderAcceptedEvent() {
    }

    public OrderAcceptedEvent(
            Long orderId,
            Long customerId,
            String status
    ) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getStatus() {
        return status;
    }
}