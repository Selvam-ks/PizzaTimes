package com.order.PizzaService.service.order;

import com.order.PizzaService.domain.OrderGen;

import java.util.List;

public interface OrderService {
    OrderGen addOderToList(OrderGen order,String email);
    OrderGen createOrderDocument(String email);
    List<OrderGen> getAllOrder(String email);
}
