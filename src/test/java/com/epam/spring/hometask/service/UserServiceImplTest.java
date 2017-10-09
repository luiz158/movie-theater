package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.UserRepository;
import com.epam.spring.hometask.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    private User user1;
    private User user2;
    private User user3;
    private static Map<Long, User> userMap;


    @Before
    public void setUp() throws Exception {
        user1 = new User();
        user1.setId(1L);
        user1.setFirstName("Ivan");
        user1.setLastName("Ivanov");
        user1.setEmail("ivanov@mail.com");

        user2 = new User();
        user1.setId(2L);
        user2.setFirstName("John");
        user2.setLastName("Smith");
        user2.setEmail("smith@mail.com");

        user3 = new User();
        user1.setId(3L);
        user3.setFirstName("Gans");
        user3.setLastName("Schmidt");
        user3.setEmail("schmidt@mail.com");

        userMap = new HashMap<>();
        userMap.put(user1.getId(), user1);


    }

    @Test
    public void getUserByEmail() throws Exception {
    }

    @Test
    public void save() throws Exception {
        User savedUser = userService.save(user1);
        assertEquals(savedUser, user1);
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}