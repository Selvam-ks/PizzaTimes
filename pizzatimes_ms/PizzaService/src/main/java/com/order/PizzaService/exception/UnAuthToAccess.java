package com.order.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,code = HttpStatus.UNAUTHORIZED,reason = "UNAUTHORIZED to access")
public class UnAuthToAccess extends Exception{
}
