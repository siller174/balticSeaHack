package com.baltichack.view.repos;

import com.baltichack.view.entity.EventStats;
import org.springframework.data.repository.CrudRepository;

public interface StatsEventRepo extends CrudRepository<EventStats, Long> {

    void putIfExist(EventStats eventStats);
}
