package com.order.PizzaService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderList {
    @Id
    private int order_id;
    private List<Product> productList;
}
