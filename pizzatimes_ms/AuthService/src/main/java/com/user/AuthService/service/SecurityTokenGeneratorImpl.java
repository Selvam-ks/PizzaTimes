package com.user.AuthService.service;
import com.user.AuthService.domain.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String, String> generateToken(UserInfo user) {
        String jwtToken;
        Instant now = Instant.now();
        Map<String,Object> userData = new HashMap<>();
        user.setPassword("");
        userData.put("User_Role",user.getRole());
        userData.put("User_email",user.getEmail());
        jwtToken = Jwts.builder()
                .setClaims(userData)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256,"platinumSecretKey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("Token",jwtToken);
        map.put("role", user.getRole());
        map.put("message","User successfully logged in");
        return map;
    }
}
