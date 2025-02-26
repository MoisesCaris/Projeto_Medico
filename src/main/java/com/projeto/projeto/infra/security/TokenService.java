package com.projeto.projeto.infra.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.projeto.projeto.models.UserModels;
import org.springframework.stereotype.Service;

@Service
public class TokenService {


    public String generateToken(UserModels user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
        }catch (Exception e) {}
    }
}
