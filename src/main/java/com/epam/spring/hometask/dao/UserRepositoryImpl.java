package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private static Map<Long, User> userMap = new HashMap<>();

    public static Map<Long, User> getUserMap() {
        return userMap;
    }

    @Override
    public User save(@Nonnull User user) {
        userMap.put(user.getId(), user);
        return userMap.get(user.getId());
    }

    @Override
    public void remove(@Nonnull User user) {
        userMap.remove(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userMap.get(id);
    }

    @Nonnull
    @Override
    public Map<Long, User> getAll() {
        return userMap;
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        User user = null;
        for (Map.Entry<Long, User> mapEntry : userMap.entrySet()) {
            if (mapEntry.getValue().getEmail().equals(email)) {
                user = mapEntry.getValue();
            }
        }
        return user;
    }
}
