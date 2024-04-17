package com.ubs.reactive.spring.boot.service;

import com.ubs.reactive.spring.boot.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    public Mono<List<Item>> getItems(Integer orderId) {
        List<Item> items = Arrays.asList(
                Item.builder().id(1).name("iPhone 13 Pro").price(5000.00).quantity(1).orderId(orderId).build(),
                Item.builder().id(2).name("Charger").price(50.00).quantity(1).orderId(orderId).build(),
                Item.builder().id(3).name("Protector").price(20.00).quantity(2).orderId(orderId).build()
        );

        return Mono.just(items).delayElement(Duration.ofSeconds(2));
    }
}
