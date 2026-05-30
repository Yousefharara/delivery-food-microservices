//package com.deliveryfood.payment_service.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentConsumer {
//
//    @KafkaListener(
//            topics = "order-events",
//            groupId = "payment-group"
//    )
//    public void consume(String message) {
//
//        System.out.println(
//                "Received Order Event: " + message
//        );
//    }
//}