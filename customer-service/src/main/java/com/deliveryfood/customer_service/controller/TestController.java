package com.deliveryfood.customer_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/")
    public String home() {
        return "Customer Service Running! Database is created ";
    }
}