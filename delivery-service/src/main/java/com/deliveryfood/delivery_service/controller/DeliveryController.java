package com.deliveryfood.delivery_service.controller;

import com.deliveryfood.delivery_service.model.Delivery;
import com.deliveryfood.delivery_service.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(
            DeliveryService deliveryService
    ) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(
            @PathVariable Long id
    ) {
        return deliveryService.getById(id);
    }

    @PutMapping("/{id}/status")
    public Delivery updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return deliveryService.updateStatus(id, status);
    }
}