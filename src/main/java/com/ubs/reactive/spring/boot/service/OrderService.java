package com.ubs.reactive.spring.boot.service;

import com.ubs.reactive.spring.boot.model.Order;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class OrderService {

    public Mono<Order> getOrder(Integer orderId) {

        Order order = Order.builder().id(orderId).name("First Order").paymentMethod("Card").build();
        return Mono.just(order).delayElement(Duration.ofSeconds(5));
    }
}
