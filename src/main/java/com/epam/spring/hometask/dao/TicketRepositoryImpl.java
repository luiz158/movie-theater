package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class TicketRepositoryImpl implements TicketRepository {

    private static Map<User, Ticket> ticketMap = new HashMap<>();

    @Override
    public Ticket save(@Nonnull Ticket ticket) {
        ticketMap.put(ticket.getUser(), ticket);
        return ticketMap.get(ticket.getUser());
    }

    @Override
    public void remove(@Nonnull Ticket ticket) {
        ticketMap.remove(ticket.getUser());

    }

    @Override
    public Ticket getByUser(@Nonnull User user) {
        return ticketMap.get(user);
    }

    @Nonnull
    @Override
    public Map<User, Ticket> getAll() {
        return ticketMap;
    }
}
