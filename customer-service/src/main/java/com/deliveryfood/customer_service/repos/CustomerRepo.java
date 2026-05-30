package com.deliveryfood.customer_service.repos;

import com.deliveryfood.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}




