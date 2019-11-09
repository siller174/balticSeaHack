package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import com.baltichack.view.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.baltichack.view.service.UserService.flag;

@Service
public class EventService {

    private List<Event> list = new ArrayList<>();




    @Autowired
    private EventRepo eventRepo;

    public void addEvent(Event event) {
        if (flag) {
            list.add(event);
        }
//        eventRepo.save(event);
    }

    public Iterable<Event> listEvent() {
        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
        if(flag) {
            for (Event event : list) {
                if (id == (long) event.getId())
                    list.remove(event);
            }
        }
//        eventRepo.deleteById(id);
    }
}
