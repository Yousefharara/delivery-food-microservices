package com.deliveryfood.customer_service.service;

import com.deliveryfood.customer_service.model.Customer;
import com.deliveryfood.customer_service.repos.CustomerRepo;
import com.deliveryfood.customer_service.service.dto.OrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo repository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepo repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public String createOrderForCustomer(Long customerId) {

        String url = "http://localhost:8082/api/orders";

        OrderRequest request = new OrderRequest(
                customerId,
                "Burger",
                2
        );

        return restTemplate.postForObject(url, request, String.class);
    }


}