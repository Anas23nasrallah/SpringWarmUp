package com.example.exercise.services;

import com.example.exercise.exceptions.InvalidDateException;
import com.example.exercise.repositories.EventCountRepository;
import org.springframework.stereotype.Service;

@Service
public class EventCountServiceImpl implements EventCountService {

    private final EventCountRepository eventCountRepository;

    public EventCountServiceImpl(EventCountRepository eventCountRepository) {
        this.eventCountRepository = eventCountRepository;
    }

    @Override
    public Long getCount(int year, int month, int day, int hour){
        return eventCountRepository.getCount(year, month, day, hour);
    }
}
