package com.baltichack.view.repos;

import com.baltichack.view.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, Long> {

    List<Event> findById(String id);

}
