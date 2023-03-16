package com.movies.services.auth;

import com.movies.models.entities.User;
import org.springframework.beans.factory.annotation.Value;

public class JwtImpl implements Jwt {

    @Value("${jwt.secret}")
    String secret;

    @Value("{jwt.message}")
    String message;

    @Override
    public User verify(String token){
        return new User(1L, "name", "role");
    }
}
