package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class EventServiceImplTest {
    @Before
    public void setUp() throws Exception {
        Event event1 = new Event();
        event1.setName("Avengers");
        event1.setBasePrice(100);
        event1.setRating(EventRating.HIGH);
        event1.addAirDateTime(LocalDateTime.of(
                LocalDate.of(2017, 11, 5),
                LocalTime.of(20, 0, 0, 0)));

        Event event2 = new Event();
        event2.setName("Les miserables");
        event2.setBasePrice(50);
        event2.setRating(EventRating.MID);
        event2.addAirDateTime(LocalDateTime.of(
                LocalDate.of(2017, 10, 20),
                LocalTime.of(12,0, 0, 0)));


    }

    @Test
    public void getByName() throws Exception {
    }

    @Test
    public void save() throws Exception {
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