package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.baltichack.view.service.UserService.flag;

//import com.baltichack.view.entity.User;
//import com.baltichack.view.repos.EventRepo;

@Service
public class EventService {

    private List<Event> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(new Event((long) 1, "Event1", "/api/event/1", new String[]{"red", "blue"}));
        list.add(new Event((long) 2, "Event2", "/api/event/2", new String[]{"yellow", "green"}));
        list.add(new Event((long) 3, "Event3", "/api/event/3", new String[]{"black", "white"}));
    }

    public Event findById(Long id) {
        if (flag) {
            for (Event event : list) {
                if (id == (long) event.getId())
                    return event;
            }
        }
        return null;
    }

//    @Autowired
//    private EventRepo eventRepo;

    public void addEvent(Event event) {
        if (flag) {
            list.add(event);
        }
//        eventRepo.save(event);
    }

    public Iterable<Event> listEvent() {
        return list;
//        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
        if (flag) {
            for (Event event : list) {
                if (id == (long) event.getId())
                    list.remove(event);
            }
        }
//        eventRepo.deleteById(id);
    }
}
