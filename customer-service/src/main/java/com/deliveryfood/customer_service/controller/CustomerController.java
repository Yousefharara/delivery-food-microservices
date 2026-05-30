package com.deliveryfood.customer_service.controller;

import com.deliveryfood.customer_service.model.Customer;
import com.deliveryfood.customer_service.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Customer deleted";
    }

//

    @PostMapping("/{id}/create-order")
    public String createOrder(@PathVariable Long id) {
        return service.createOrderForCustomer(id);
    }

}