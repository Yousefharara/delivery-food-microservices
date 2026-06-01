# Food Delivery System - Microservices Architecture

A distributed Food Delivery System built using Spring Boot Microservices, RabbitMQ, MySQL, JPA, and Docker.

## Architecture

The system consists of four microservices:

* Customer Service
* Order Service
* Payment Service
* Delivery Service

### Communication Flow

```text
Customer ──(Sync REST)──► Order
                              │
                              │ OrderCreated Event
                              ▼
                         Payment
                          │   │
                          │   └──► Delivery
                          │
                          └──► Order

Delivery ──► Customer
```

## Technologies

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* RabbitMQ
* Docker Desktop
* Maven

## Communication Patterns

| Source   | Destination | Type                       |
| -------- | ----------- | -------------------------- |
| Customer | Order       | Synchronous REST           |
| Order    | Payment     | Asynchronous RabbitMQ      |
| Payment  | Order       | Asynchronous RabbitMQ      |
| Payment  | Delivery    | Asynchronous RabbitMQ      |
| Delivery | Customer    | Asynchronous Notifications |

## Running RabbitMQ

```bash
docker run -d \
--hostname rabbitmq \
--name rabbitmq \
-p 5672:5672 \
-p 15672:15672 \
rabbitmq:3-management
```

RabbitMQ Dashboard:

```text
http://localhost:15672
```

Default Credentials:

```text
Username: admin
Password: admin
```

## Project Structure

```text
food-delivery-system/
│
├── customer-service
├── order-service
├── payment-service
└── delivery-service
```

## Features

* Microservices Architecture
* Event-Driven Communication
* RabbitMQ Messaging
* REST APIs
* MySQL Integration
* Spring Data JPA

## Author

**Yousef Harara**

Advanced Software Engineering (SDEV 4304)

Islamic University of Gaza
