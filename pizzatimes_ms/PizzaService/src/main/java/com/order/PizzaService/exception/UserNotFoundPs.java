package com.order.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found OR Incorrect Password/Username")
public class UserNotFoundPs extends Exception{
}
