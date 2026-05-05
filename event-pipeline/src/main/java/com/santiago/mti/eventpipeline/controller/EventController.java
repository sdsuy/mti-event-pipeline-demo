package com.santiago.mti.eventpipeline.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.mti.eventpipeline.dto.WebinarEventRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {
    
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, Object> receiveEvent(@Valid @RequestBody WebinarEventRequest request) {
        return Map.of(
                "status", "ACCEPTED",
                "webinarId", request.getWebinarId(),
                "attendeeEmail", request.getAttendeeEmail(),
                "receivedAt", Instant.now().toString()
        );
    }
}
