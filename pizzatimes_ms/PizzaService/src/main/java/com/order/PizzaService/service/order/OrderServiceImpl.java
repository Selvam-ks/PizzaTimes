package com.order.PizzaService.service.order;

import com.order.PizzaService.domain.OrderGen;
import com.order.PizzaService.repository.OrderRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRespo orderRespo;
    @Override
    public OrderGen addOderToList(OrderGen order,String email) {
        if(orderRespo.findById(email).isEmpty()) {
        }
        return null;
    }

    @Override
    public OrderGen createOrderDocument(String email) {
        
        return null;
    }

    @Override
    public List<OrderGen> getAllOrder(String email) {
        return null;
    }
}
