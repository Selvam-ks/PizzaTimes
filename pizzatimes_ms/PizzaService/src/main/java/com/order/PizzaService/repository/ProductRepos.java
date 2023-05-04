package com.order.PizzaService.repository;

import com.order.PizzaService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepos extends MongoRepository<Product,String> {
}
