package com.example.exercise.controllers;

import com.example.exercise.exceptions.InvalidDateException;
import com.example.exercise.services.EventCountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventCountController {

    private final EventCountServiceImpl eventCountService;

    public EventCountController(EventCountServiceImpl eventCountService) {
        this.eventCountService = eventCountService;
    }

    @GetMapping("/publisher/event_count/{year}/{month}/{day}/{hour}")
    @ResponseBody
    public Long getCount(@PathVariable int year, @PathVariable int month, @PathVariable int day, @PathVariable int hour) throws InvalidDateException {
//        try{
            return eventCountService.getCount(year, month, day, hour);
//        } catch (InvalidDateException e){
//            System.out.println(e.getMessage());
//            return -1l;
//        }
    }

}
