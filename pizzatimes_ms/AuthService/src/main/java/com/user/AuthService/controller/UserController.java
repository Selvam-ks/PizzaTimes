package com.user.AuthService.controller;

import com.user.AuthService.domain.UserInfo;
import com.user.AuthService.exception.UserAlreadyExists;
import com.user.AuthService.service.SecurityTokenGenerator;
import com.user.AuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pizzaTimes/user/")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private SecurityTokenGenerator tokenGenerator;

    @PostMapping("signUp")
    public ResponseEntity<?> saveUser(@RequestBody UserInfo userInfo) throws UserAlreadyExists {
        userInfo.setRole("user");
        return new ResponseEntity<>(service.saveNewUser(userInfo), HttpStatus.CREATED);
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserInfo userInfo){
        UserInfo result = service.loginCheck(userInfo);
        if(result!=null){
            return new ResponseEntity<>(tokenGenerator.generateToken(result),HttpStatus.OK);
        }else
            return new ResponseEntity<>("Authentication Failed", HttpStatus.OK);
    }
}
