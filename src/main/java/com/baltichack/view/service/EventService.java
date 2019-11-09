package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.baltichack.view.service.UserService.flag;

//import com.baltichack.view.entity.User;
//import com.baltichack.view.repos.EventRepo;

@Service
public class EventService {
    @SuppressWarnings("unchecked")
    private Map<Long, Event> map = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        map.put((long) 1, new Event((long) 1, "Event1", "http://www.yahoo.com", new String[]{"red", "blue"}));
        map.put((long) 2, new Event((long) 2, "Event2", "http://www.ya.ru", new String[]{"black", "white"}));
        map.put((long) 3, new Event((long) 3, "Event3", "http://www.google.ru", new String[]{"red", "yelllow"}));
    }

    public Event findById(Long id) {
        if (flag) {
            if (map.containsKey(id)) {
                return map.get(id);
            }
        }
        return null;
    }

//    @Autowired
//    private EventRepo eventRepo;

    public void addEvent(Event event) {
        if (flag) {
            if (!map.containsKey(event.getId())) {
                map.put(event.getId(), event);
            }
        }
//        eventRepo.save(event);
    }

    public Collection<Event> listEvent() {
        return map.values();
//        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
        if (flag) {
            map.remove(id);
        }
//        eventRepo.deleteById(id);
    }
}
