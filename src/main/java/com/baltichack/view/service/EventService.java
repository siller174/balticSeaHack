package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import com.baltichack.view.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;


    public Optional<Event> findById(Long id) {
        return eventRepo.findById(id);
    }

    public void addEvent(Event event) {
        eventRepo.save(event);
    }

    public Iterable<Event> listEvent() {
        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
        eventRepo.deleteById(id);
    }
}
