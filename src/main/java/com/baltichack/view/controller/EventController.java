package com.baltichack.view.controller;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import com.baltichack.view.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long eventId) {

        eventRepo.removeEvent(eventId);
        return "redirect:/";
    }

    @RequestMapping("/checkIn/{id}")
    public RedirectView checkIn(@PathVariable("id") Long eventId,
                                @RequestParam("user") User user) {

        //todo add checin user


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(eventRepo.findById(eventId).getRedirectUrl());
        return redirectView;
    }

    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getQRcode(@PathVariable("id") Long eventId) {
        return new FileSystemResource();
    }

}
