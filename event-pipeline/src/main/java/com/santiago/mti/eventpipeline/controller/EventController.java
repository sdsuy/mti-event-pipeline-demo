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
import com.santiago.mti.eventpipeline.entity.WebinarEvent;
import com.santiago.mti.eventpipeline.repository.WebinarEventRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final WebinarEventRepository repository;
    
    public EventController(WebinarEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, Object> receiveEvent(@Valid @RequestBody WebinarEventRequest request) {
        WebinarEvent event = new WebinarEvent(
                request.getWebinarId(),
                request.getAttendeeName(),
                request.getAttendeeEmail(),
                request.getDurationMinutes()
        );

        WebinarEvent savedEvent = repository.save(event);

        return Map.of(
                "status", "ACCEPTED",
                "eventId", savedEvent.getId(),
                "webinarId", savedEvent.getWebinarId(),
                "attendeeEmail", savedEvent.getAttendeeEmail(),
                "receivedAt", Instant.now().toString()
        );
    }
}
