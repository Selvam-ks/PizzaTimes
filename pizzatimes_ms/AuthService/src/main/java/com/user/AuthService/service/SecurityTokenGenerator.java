package com.user.AuthService.service;


import com.user.AuthService.domain.UserInfo;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(UserInfo user);
}
