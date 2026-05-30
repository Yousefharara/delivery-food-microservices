package com.deliveryfood.customer_service.event;

public class DeliveryStatusUpdatedEvent {

    private Long deliveryId;
    private Long customerId;
    private String deliveryStatus;

    public DeliveryStatusUpdatedEvent() {
    }

    public DeliveryStatusUpdatedEvent(
            Long deliveryId,
            Long customerId,
            String deliveryStatus
    ) {
        this.deliveryId = deliveryId;
        this.customerId = customerId;
        this.deliveryStatus = deliveryStatus;
    }

    // getters setters

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}