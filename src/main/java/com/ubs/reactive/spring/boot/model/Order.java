package com.ubs.reactive.spring.boot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String name;
    private List<Item> items;
    private String paymentMethod;

}
