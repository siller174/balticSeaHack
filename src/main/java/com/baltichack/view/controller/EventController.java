package com.baltichack.view.controller;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import com.baltichack.view.service.EventService;
import com.baltichack.view.service.QRcodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventRepo;

    @Autowired
    private QRcodeService qRcodeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Event> listEvents() {
        return eventRepo.listEvent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {
        eventRepo.addEvent(event);
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        eventRepo.removeEvent(eventId);
    }

    @RequestMapping(value = "/checkIn/{eventId}", method = RequestMethod.POST)
    public RedirectView checkIn(@PathVariable("eventId") Long eventId,
                                @RequestBody User user) {

        //todo add checin user


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(eventRepo.findById(eventId).getRedirectUrl());
        return redirectView;
    }

    @ResponseBody
    @RequestMapping(value = "/getQRcode/{id}", method = RequestMethod.GET)
    public FileSystemResource getQRcode(@PathVariable("id") Long eventId) throws WriterException, IOException {
        Event event = eventRepo.findById(eventId);
        return qRcodeService.getQRcode(eventId, event.getRedirectUrl());
    }
}
