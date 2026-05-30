package com.deliveryfood.delivery_service.event;

public class OrderReadyForDeliveryEvent {

    private Long orderId;

    private Long customerId;

    private String orderStatus;

    public OrderReadyForDeliveryEvent() {
    }

    public OrderReadyForDeliveryEvent(
            Long orderId,
            Long customerId,
            String orderStatus
    ) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}