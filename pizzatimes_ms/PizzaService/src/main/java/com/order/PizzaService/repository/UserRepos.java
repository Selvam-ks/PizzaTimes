package com.order.PizzaService.repository;

import com.order.PizzaService.domain.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends MongoRepository<UserInfo, String> {
}
