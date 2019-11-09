package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
//import com.baltichack.view.entity.User;
//import com.baltichack.view.repos.EventRepo;
import com.baltichack.view.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.baltichack.view.service.UserService.flag;

@Service
public class EventService {
    @SuppressWarnings("unchecked")
    private Map<Long, Event> map = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        map.put(1L, new Event((long) 1, "Event1", "/api/event/1"));
        map.put(2L, new Event((long) 2, "Event2", "/api/event/2"));
        map.put(3L, new Event((long) 3, "Event3", "/api/event/3"));

    }

    public Event findById(Long id) {
        if (flag) {
            for (Map.Entry<Long, Event> map: map.entrySet() ) {
                if ((long) map.getKey() == id) {
                    return map.getValue();
                }
            }
        }
        return null;
    }

//    @Autowired
//    private EventRepo eventRepo;

    public void addEvent(Long Id, Event event) {
        if (flag) {
            if (!map.containsKey(Id)) {
                map.put(Id, event);
            }
        }
//        eventRepo.save(event);
    }

    public Iterable<Long> listEvent() {
        return map.keySet();
//        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
        if(flag) {
                map.remove(id);
        }
//        eventRepo.deleteById(id);
    }
}
