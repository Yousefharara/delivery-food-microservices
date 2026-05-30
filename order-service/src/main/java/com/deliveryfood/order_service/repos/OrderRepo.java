package com.deliveryfood.order_service.repos;

import com.deliveryfood.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long>{
}