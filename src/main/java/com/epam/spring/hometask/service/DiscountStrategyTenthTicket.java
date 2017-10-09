package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class DiscountStrategyTenthTicket implements DiscountStrategy {
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        byte discount;
        if (user != null) {
            discount = (byte) (((user.getTickets().size() + numberOfTickets) % 10) > 0 ? 5 : 0);
        } else {
            discount = (byte) ((numberOfTickets % 10) > 0 ? 5 : 0);
        }
        return discount;
    }
}
