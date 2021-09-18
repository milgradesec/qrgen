package com.github.milgradesec.qrgen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthEndpointController {

    @RequestMapping("/health")
    public String getStatus() {
        return "OK";
    }
}
