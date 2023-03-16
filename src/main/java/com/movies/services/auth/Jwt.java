package com.movies.services.auth;

import com.movies.models.entities.User;

public interface Jwt {
    public User verify(String token);
}
