package com.order.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,value = HttpStatus.CONFLICT,reason = "ProductNotFound")
public class ProductNotFoundPs extends Exception{
}
