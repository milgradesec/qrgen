package com.github.milgradesec.qrgen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthEndpointController {

    @RequestMapping("/health")
    public String getStatus() {
        return "OK";
    }
}
