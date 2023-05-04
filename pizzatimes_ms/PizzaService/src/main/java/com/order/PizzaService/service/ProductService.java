package com.order.PizzaService.service;

import com.order.PizzaService.domain.Product;
import com.order.PizzaService.exception.ProductAlreadyPresentPs;
import com.order.PizzaService.exception.ProductNotFoundPs;

public interface ProductService {
    Product AddProduct(Product product) throws ProductAlreadyPresentPs;
    boolean deleteProduct(String product_name) throws ProductNotFoundPs;
    Product updateProduct(Product product) throws ProductNotFoundPs;
    Product getA_Product(String product_name);
}
