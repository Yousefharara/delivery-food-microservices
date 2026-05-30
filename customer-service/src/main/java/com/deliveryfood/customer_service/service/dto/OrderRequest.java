package com.deliveryfood.customer_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
    private Long customerId;
    private String itemName;
    private Integer quantity;
}