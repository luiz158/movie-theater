package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class EventRepositoryImpl implements EventRepository {
    private static Map<Long, Event> eventMap = new HashMap<>();

    public EventRepositoryImpl() {

    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        Event event = null;
        for (Map.Entry<Long, Event> mapEntry : eventMap.entrySet()){
            if (mapEntry.getValue().getName().equals(name)) {
                event = mapEntry.getValue();
            }
        }
        return event;
    }

    @Override
    public Event save(@Nonnull Event event) {
        eventMap.put(event.getId(), event);
        return eventMap.get(event.getId());
    }

    @Override
    public void remove(@Nonnull Event event) {
        eventMap.remove(event.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventMap.get(id);
    }

    @Nonnull
    @Override
    public Map<Long, Event> getAll() {
        return eventMap;
    }
}
