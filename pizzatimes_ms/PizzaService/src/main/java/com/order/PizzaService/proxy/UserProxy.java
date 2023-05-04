package com.order.PizzaService.proxy;

import com.order.PizzaService.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-auth",url = "http://localhost:17899")
public interface UserProxy {

    @PostMapping("pizzaTimes/user/signUp")
    public ResponseEntity<?> userRegistration(@RequestBody UserInfo user);
}
