package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.UserRepository;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User save(@Nonnull User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(@Nonnull User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userRepository.getById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return (Collection<User>) userRepository.getAll();
    }
}
