package com.santiago.mti.eventpipeline.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.santiago.mti.eventpipeline.dto.WebinarEventRequest;
import com.santiago.mti.eventpipeline.entity.WebinarEvent;
import com.santiago.mti.eventpipeline.repository.WebinarEventRepository;

@Service
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    private final WebinarEventRepository repository;

    public EventService(WebinarEventRepository repository) {
        this.repository = repository;
    }

    public WebinarEvent receiveEvent(WebinarEventRequest request) {
        logger.info("Receiving webinar event. webinarId={}, attendeeEmail={}",
                request.getWebinarId(),
                request.getAttendeeEmail());

        WebinarEvent event = new WebinarEvent(
                request.getWebinarId(),
                request.getAttendeeName(),
                request.getAttendeeEmail(),
                request.getDurationMinutes()
        );

        WebinarEvent savedEvent = repository.save(event);

        logger.info("Webinar event persisted. eventId={}, webinarId={}",
                savedEvent.getId(),
                savedEvent.getWebinarId());

        return savedEvent;
    }
}
