package com.order.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,value = HttpStatus.CONFLICT ,reason = "ProductAlreadyPresent")
public class ProductAlreadyPresentPs extends Exception{
}
