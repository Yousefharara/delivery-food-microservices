package com.deliveryfood.order_service.event;

public class OrderCreatedEvent {

    private Long orderId;
    private Long customerId;
    private String itemName;
    private Integer quantity;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long orderId,
                             Long customerId,
                             String itemName,
                             Integer quantity) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }



}