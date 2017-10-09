package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.TicketRepository;
import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.sun.javafx.collections.MappingChange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private DiscountService discountService;
    private TicketRepository ticketRepository;

    public BookingServiceImpl(DiscountService discountService, TicketRepository ticketRepository) {
        this.discountService = discountService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        Auditorium auditoriumForGivenDateTime = event.getAuditoriums().get(dateTime);
        long totalAmountOfSeats = seats.size();
        long amountOfVIpSeats = auditoriumForGivenDateTime.countVipSeats(seats);
        long amountOfRegularSeats = totalAmountOfSeats - amountOfVIpSeats;

        double singleTicketPriceBasedOnEventRatio = calculatePriceBasedOnEventRating(event);

        double priceWithoutDiscount = singleTicketPriceBasedOnEventRatio * (2 * amountOfVIpSeats + amountOfRegularSeats);

        int discount = discountService.getDiscount(user, event, dateTime, seats.size());

        return priceWithoutDiscount * (1 - ((double)discount / 100));
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            if (ticket.getUser() != null) {
                ticketRepository.save(ticket);
            }
            else {
                ticket.setUser(new User());
                ticketRepository.save(ticket);
            }
        }
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        Map<User, Ticket> userTicketMap = ticketRepository.getAll();
        Set<Ticket> purchasedTickets = Collections.emptySet();
        for(Map.Entry<User, Ticket> pair : userTicketMap.entrySet()) {
            if ((pair.getValue().getEvent().equals(event)) && (pair.getValue().getDateTime().equals(dateTime))) {
                purchasedTickets.add(pair.getValue());
            }
        }
        return purchasedTickets;

    }

    private double calculatePriceBasedOnEventRating(Event event) {
        switch (event.getRating()) {
            case LOW:
                return (event.getBasePrice() * 0.8);
            case HIGH:
                return (event.getBasePrice() * 1.2);
            case MID:
                return event.getBasePrice();
            default:
                return event.getBasePrice();
        }
    }
}
