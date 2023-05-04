package com.order.PizzaService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Product {
    private int product_id;
    @Id
    private String name;
    private String type_vg;
    private String description;
    private String size;
    private String crust;
    private double price;
    private int qty;
    private String imageurl;
}

