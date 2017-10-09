package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class DiscountStrategyBirthday implements DiscountStrategy {
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        boolean birthdayDiscount = false;
        if (user != null) {
            birthdayDiscount = (user.getDateOfBirth().getMonthValue() == airDateTime.getMonthValue())
                    && (Math.abs(user.getDateOfBirth().getDayOfMonth() - airDateTime.getDayOfMonth()) <= 5);
        }
        return (byte) (birthdayDiscount ? 10 : 0);
    }
}
