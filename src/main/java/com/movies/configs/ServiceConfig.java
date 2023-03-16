package com.movies.configs;

import com.movies.repositories.OmdbRepository;
import com.movies.services.movies.MoviesApi.OmdbRepositoryFake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public OmdbRepository omdbRepository(){
        return new OmdbRepositoryFake();
    }
}
