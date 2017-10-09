package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.util.Map;

public interface TicketRepository {
    Ticket save(@Nonnull Ticket ticket);

    void remove(@Nonnull Ticket ticket);

    Ticket getByUser(@Nonnull User user);

    @Nonnull
    Map<User, Ticket> getAll();
}
