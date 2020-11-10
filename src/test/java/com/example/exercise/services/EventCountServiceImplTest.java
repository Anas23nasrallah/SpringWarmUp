package com.example.exercise.services;

import com.example.exercise.exceptions.InvalidDateException;
import com.example.exercise.repositories.EventCountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;;


public class EventCountServiceImplTest {

    EventCountServiceImpl eventCountService;

    @Mock
    EventCountRepository eventCountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        eventCountService = new EventCountServiceImpl(eventCountRepository);
    }

    @Test
    public void getCountTest1(){
        int year = 2020;
        int month = 10;
        int day = 2;
        int hour = 3;
        when(eventCountRepository.getCount(year, month, day, hour)).thenReturn(326099l);
        long count = eventCountService.getCount(year, month, day, hour);
        assertEquals(326099l, count);
    }

    @Test
    public void getCountTest2(){
        int year = 2020;
        int month = 11;
        int day = 6;
        int hour = 21;
        when(eventCountRepository.getCount(year, month, day, hour)).thenReturn(1791210l);
        long count = eventCountService.getCount(year, month, day, hour);
        assertEquals(1791210l, count);
    }

    @Test(expected = InvalidDateException.class)
    public void getCountTest3() throws InvalidDateException{
        int year = 202;
        int month = 11;
        int day = 6;
        int hour = 21;
        when(eventCountRepository.getCount(year, month, day, hour)).thenThrow(new InvalidDateException());
        eventCountService.getCount(year, month, day, hour);
    }

    @Test(expected = InvalidDateException.class)
    public void getCountTest4() throws InvalidDateException{
        int year = 2020;
        int month = 11;
        int day = 60;
        int hour = 21;
        when(eventCountRepository.getCount(year, month, day, hour)).thenThrow(new InvalidDateException());
        eventCountService.getCount(year, month, day, hour);
    }
}