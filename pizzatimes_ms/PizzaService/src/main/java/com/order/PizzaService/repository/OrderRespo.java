package com.order.PizzaService.repository;

import com.order.PizzaService.domain.OrderGen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespo extends MongoRepository<OrderGen ,String> {
}
