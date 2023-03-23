package com.movies.configs;

import com.movies.repositories.OmdbRepository;
import com.movies.services.movies.MoviesApi.OmdbApi;
import com.movies.services.movies.MoviesApi.OmdbRepositoryFake;
import com.movies.services.movies.MoviesApi.OmdbRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ServiceConfig {

    @Autowired
    private Environment env;



    @Bean
    public OmdbRepository omdbRepository(){

        String omdbLive = env.getProperty("omdb.live");

        if (omdbLive.equals("live")){
            return new OmdbRepositoryImpl(omdbApi());
        }
        return new OmdbRepositoryFake();
    }

    @Bean
    public OmdbApi omdbApi(){
        return new OmdbApi();
    }


}
