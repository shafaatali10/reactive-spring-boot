package com.ubs.reactive.spring.boot.controller;

import com.ubs.reactive.spring.boot.model.Item;
import com.ubs.reactive.spring.boot.model.Order;
import com.ubs.reactive.spring.boot.service.ItemService;
import com.ubs.reactive.spring.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService orderItemsService;

    @GetMapping("/{orderId}")
    private Mono<Order> getOrderDetails(@PathVariable Integer orderId) {

        Mono<Order> orderToReturn = orderService.getOrder(orderId)

                .zipWith(orderItemsService.getItems(orderId))

                .map(tuple -> {
                    Order order = tuple.getT1();
                    order.setItems(tuple.getT2());
                    return order;
                });

        System.out.println("This should print immediately even if the browser is still waiting");
        // If the above statement is printed, this method is non-blocking

        return orderToReturn;
    }
}
