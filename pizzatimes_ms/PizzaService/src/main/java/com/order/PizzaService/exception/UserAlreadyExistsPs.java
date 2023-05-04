package com.order.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,code = HttpStatus.FORBIDDEN ,reason = "Username Already Taken")
public class UserAlreadyExistsPs extends Exception{
}
