package com.movies.http.controllers;

import com.movies.services.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final DashboardService dashboardService;

    public HelloController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String index(){
        return dashboardService.dashboard();
    }
}
