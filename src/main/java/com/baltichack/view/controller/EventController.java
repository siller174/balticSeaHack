package com.baltichack.view.controller;

import com.baltichack.view.entity.Event;
import com.baltichack.view.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventRepo;

    @RequestMapping("/")
    public Iterable<Event> listEvents() {

       return eventRepo.listEvent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEvent(@RequestParam("Event") Event event) {

        eventRepo.addEvent(event);

        return "redirect:/";
    }

    @RequestMapping("/delete/{EventId}")
    public String deleteEvent(@PathVariable("EventId") Long eventId) {

        eventRepo.removeEvent(eventId);
        return "redirect:/";
    }


}
