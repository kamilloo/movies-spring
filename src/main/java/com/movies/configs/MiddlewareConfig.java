package com.movies.configs;

import com.movies.http.middlewres.JwtMiddleware;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiddlewareConfig {

    @Bean
    public FilterRegistrationBean jwtMiddleware(){
        FilterRegistrationBean middleware = new FilterRegistrationBean();
        middleware.setFilter(new JwtMiddleware());

        middleware.addUrlPatterns("/movies");
        return middleware;
    }
}
