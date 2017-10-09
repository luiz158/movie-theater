package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService {
    private Set<Auditorium> auditoriumSet;

    public AuditoriumServiceImpl(Set<Auditorium> auditoriumSet) {
        this.auditoriumSet = auditoriumSet;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return this.auditoriumSet;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        Auditorium auditorium = null;
        for (Auditorium aud : auditoriumSet) {
            String audName = aud.getName();
            if (audName.equals(name)) {
                auditorium = aud;
            }
        }
        return auditorium;
    }
}
