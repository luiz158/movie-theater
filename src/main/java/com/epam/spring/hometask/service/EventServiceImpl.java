package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.EventRepository;
import com.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;


    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventRepository.getByName(name);
    }

    @Override
    public Event save(@Nonnull Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void remove(@Nonnull Event event) {
        eventRepository.remove(event);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventRepository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return (Collection<Event>) eventRepository.getAll();
    }
}
