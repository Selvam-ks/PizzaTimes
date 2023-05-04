package com.order.PizzaService.service;

import com.order.PizzaService.domain.Product;
import com.order.PizzaService.domain.UserInfo;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.UserAlreadyExistsPs;
import com.order.PizzaService.exception.UserNotFoundPs;

import java.util.List;

public interface UserService {

    UserInfo saveNewUser(UserInfo userInfo) throws UserAlreadyExistsPs;
    boolean deleteProduct(String email ,String product_namet) throws UserNotFoundPs;
    UserInfo addProductToUser(Product product,String email) throws UserNotFoundPs, ProductAlreadyPresentPs;
    List<Product> getAllProductsFromUser(String email) throws UserNotFoundPs;
    List<Product> getAllProducts();
    UserInfo updateProduct(Product product,String email) throws UserNotFoundPs;
    boolean conformOrder(String email);




}
