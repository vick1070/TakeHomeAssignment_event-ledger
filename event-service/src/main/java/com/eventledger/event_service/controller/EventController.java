package com.eventledger.event_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/events")
    public String getEvents() {
        return "Event Service is running!";
    }
}