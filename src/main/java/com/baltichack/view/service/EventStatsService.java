package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EventStatsService {

    private Map<String, User> stats = new ConcurrentHashMap();


    public void checkInUser(String eventId, User user) {
        if (!stats.containsKey(eventId)) {
            stats.put(eventId, user);
        }
    }
}
