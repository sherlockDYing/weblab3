package com.lab3.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lab3.demo.myBatis.entity.User;
import com.lab3.demo.request.UserRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public  class TokenService {

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getUserID()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
    public String getToken(UserRegisterRequest user) {
        String token="";
        token= JWT.create().withAudience(user.getUsername())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
