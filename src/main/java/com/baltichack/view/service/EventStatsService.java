package com.baltichack.view.service;

import com.baltichack.view.entity.EventStats;
import com.baltichack.view.entity.User;
import com.baltichack.view.repos.StatsEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EventStatsService {
    @Autowired
    private StatsEventRepo statsEventRepo;

    public void checkInUser(Long eventId, User user) {
        statsEventRepo.putIfExist(new EventStats(eventId, user.getId()));
    }
}
