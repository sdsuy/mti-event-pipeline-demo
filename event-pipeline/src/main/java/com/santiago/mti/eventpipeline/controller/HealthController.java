package com.santiago.mti.eventpipeline.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    @GetMapping("/api/events/test")
    public Map<String, String> testEvent() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Event pipeline is working");
        return response;
    }
}
