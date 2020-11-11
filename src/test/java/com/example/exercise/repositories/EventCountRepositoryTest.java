package com.example.exercise.repositories;

import com.example.exercise.configurations.SparkConfigurations;
import com.example.exercise.exceptions.InvalidDateException;
import com.example.exercise.services.EventCountServiceImpl;
import org.apache.spark.sql.SparkSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SparkConfigurations.class})
public class EventCountRepositoryTest {

    EventCountRepository eventCountRepository;

//    @Mock
    @Autowired
    SparkSession sparkSession;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        eventCountRepository = new EventCountRepository(sparkSession);
    }

    @Test
    public void getCountTest1(){
        int year = 2020;
        int month = 11;
        int day = 6;
        int hour = 2;
        long count = eventCountRepository.getCount(year, month, day, hour);
        assertEquals(1281118l, count);
    }

    @Test(expected = InvalidDateException.class)
    public void getCountTest3() throws InvalidDateException{
        int year = 2020;
        int month = 11;
        int day = 6;
        int hour = 42;
        eventCountRepository.getCount(year, month, day, hour);
    }


}

