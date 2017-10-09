package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public interface UserRepository {

    User save(@Nonnull User object);

    void remove(@Nonnull User object);

    User getById(@Nonnull Long id);

    @Nonnull
    Map<Long, User> getAll();

    @Nullable
    User getUserByEmail(@Nonnull String email);


}
